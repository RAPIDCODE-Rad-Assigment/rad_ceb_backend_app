package com.rapidcode.api.user;

import com.rapidcode.api.common.PageResponse;
import com.rapidcode.api.email.EmailService;
import com.rapidcode.api.handler.CannotChangeStatusException;
import com.rapidcode.api.handler.OperationNotPermittedException;
import com.rapidcode.api.handler.UserNotFoundException;
import com.rapidcode.api.role.RoleName;
import com.rapidcode.api.token.TokenRepository;
import com.rapidcode.api.util.TokenUtils;
import com.rapidcode.api.util.UserUtils;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserService implements UserServiceInterface {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final UserMapper userMapper;
    private final ImageHelper imageHelper;
    private final UserUtils userUtils;
    private final TokenUtils tokenUtils;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;

    public UserService(PasswordEncoder passwordEncoder,UserRepository repository, UserMapper userMapper, ImageHelper imageHelper, UserUtils userUtils, TokenUtils tokenUtils, TokenRepository tokenRepository, EmailService emailService) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
        this.userMapper = userMapper;
        this.imageHelper = imageHelper;
        this.userUtils = userUtils;
        this.tokenUtils = tokenUtils;
        this.tokenRepository = tokenRepository;
        this.emailService = emailService;
    }


    @Override
    @Transactional
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        repository.save(user);
    }

    @Transactional
    public void disableUser(UserStatusChangeRequest disableUserRequest) throws MessagingException {
        User user = repository.findByEmail(disableUserRequest.email())
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + disableUserRequest.email()));

        if (!disableUserRequest.email().equals(user.getEmail())) {
            throw new CannotChangeStatusException("Email is not associated with your account");
        }
        user.setAccountLocked(true);
        repository.save(user);

        tokenUtils.revokeAllUserTokens(user);

        var reactivationLink = "http://localhost:8080/api/v1/users/enable_user";
        userUtils.sendDeactivatedValidationEmail(user, reactivationLink);
    }


    @Override
    public UserResponse updateUserProfile(UUID id, UserRequest updateRequest) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        String currentProfileImageUrl = user.getProfile_image_url();
        String requestProfileImageUrl = updateRequest.profile_image_url();

        log.info("Updating profile for user with id: {}", id);

        // Handle the case where the profile image URL has been updated
        if (requestProfileImageUrl != null && !requestProfileImageUrl.isEmpty()) {
            if (currentProfileImageUrl != null && !currentProfileImageUrl.isEmpty() && !currentProfileImageUrl.equals(requestProfileImageUrl)) {
                log.info("Deleting old profile image: {}", currentProfileImageUrl);
                imageHelper.deleteImageFromUserDirectory(currentProfileImageUrl, user.getId());
            }

            if (imageHelper.isImageInTempDirectory(requestProfileImageUrl)) {
                log.info("Moving new profile image from temp directory: {}", requestProfileImageUrl);
                imageHelper.moveProfileImageToUserFolder(requestProfileImageUrl, user.getId());
            } else if (imageHelper.isImageInUserDirectory(requestProfileImageUrl, user.getId())) {
                log.info("Profile image already in user's directory: {}", requestProfileImageUrl);
            } else {
                log.error("Profile image not found in temp or user directory: {}", requestProfileImageUrl);
                throw new IllegalStateException("Profile image not found in temp or user directory");
            }
        } else if (requestProfileImageUrl == null || requestProfileImageUrl.isEmpty() && currentProfileImageUrl != null && !currentProfileImageUrl.isEmpty()) {
            // Remove the current profile image if the request URL is null or empty
            log.info("Removing existing profile image as request URL is null or empty: {}", currentProfileImageUrl);
            imageHelper.deleteImageFromUserDirectory(currentProfileImageUrl, user.getId());
            user.setProfile_image_url(null); // Reset profile image URL in the user object
        }

        user = userMapper.updateUserFromRequest(updateRequest, user);
        repository.save(user);
        log.info("Profile updated successfully for user with id: {}", id);
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse getCurrentUser(UserDetails userDetails){
        String email = userDetails.getUsername();
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new OperationNotPermittedException("User not found with email: " + email));
        return userMapper.toUserResponse(user);
    }


    @Override
    public PageResponse<UserResponse> getAllUsersForAdmin(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<User> users = repository.findAll(pageable);
        List<UserResponse> usersAsResponse = users.stream()
                .map(userMapper::toUserResponse)
                .toList();
        return new PageResponse<>(
                usersAsResponse,
                users.getNumber(),
                users.getSize(),
                users.getTotalElements(),
                users.getTotalPages(),
                users.isFirst(),
                users.isLast()
        );
    }

    @Override
    @Transactional
    public void deleteUser(UUID id, UserDetails userDetails) {
        var userToDelete = repository.findById(id)
                .orElseThrow(() -> new OperationNotPermittedException("User not found with id: " + id));
        var adminUser = repository.findByRoles_Name(String.valueOf(RoleName.ADMIN))
                .orElseThrow(() -> new OperationNotPermittedException("Admin user not found with email: " + userDetails.getUsername()));

        if (userToDelete.getId().equals(adminUser.getId())) {
            throw new OperationNotPermittedException("Admin cannot delete themselves");
        }

        tokenRepository.deleteByUserId(id);

        repository.delete(userToDelete);

        try {
            emailService.sendAccountDeletionEmail(userToDelete.getEmail(), userToDelete.getUsersName(), "Your Account Has Been Deleted");
        } catch (MessagingException e) {
            log.error("Failed to send account deletion email to {}: {}", userToDelete.getEmail(), e.getMessage());
        }
    }


}
