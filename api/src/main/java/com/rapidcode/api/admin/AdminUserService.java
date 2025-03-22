package com.rapidcode.api.admin;

import com.rapidcode.api.common.PageResponse;
import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.email.EmailService;
import com.rapidcode.api.handler.OperationNotPermittedException;
import com.rapidcode.api.role.Role;
import com.rapidcode.api.role.RoleName;
import com.rapidcode.api.role.RoleRepository;
import com.rapidcode.api.token.TokenRepository;
import com.rapidcode.api.user.User;
import com.rapidcode.api.user.UserMapper;
import com.rapidcode.api.user.UserRepository;
import com.rapidcode.api.user.UserResponse;
import com.rapidcode.api.util.UserUtils;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminUserService implements AdminUserServiceInterface{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserUtils userUtils;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;

    @Override
    public ResultResponse<UserResponse> registerUser(RegisterUserRequest request) throws MessagingException {
        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        String rawPassword = UUID.randomUUID().toString();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        User user = User.builder()
                .usersName(request.getUsername())
                .email(request.getEmail())
                .fullName(request.getFullName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .password(encodedPassword)
                .enabled(true)
                .accountLocked(false)
                .createdDate(LocalDateTime.now())
                .roles(List.of(role))
                .build();

        User savedUser = userRepository.save(user);

        UserResponse userResponse = userMapper.toUserResponse(savedUser);
        userUtils.sendAccountCreatedEmail(user.getEmail(), rawPassword, user.getFullName());


        return ResultResponse.<UserResponse>builder()
                .status("success")
                .data(userResponse)
                .build();
    }


    public PageResponse<UserResponse> getAllUsersForAdmin(int page, int size, String name, String role) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<User> users;

        if (name != null && !name.isEmpty() && role != null && !role.isEmpty()) {
            users = userRepository.findByFullNameContainingIgnoreCaseAndRoles_Name(name, role, pageable);
        } else if (name != null && !name.isEmpty()) {
            users = userRepository.findByFullNameContainingIgnoreCase(name, pageable);
        } else if (role != null && !role.isEmpty()) {
            users = userRepository.findByRoles_Name(role, pageable);
        } else {
            users = userRepository.findAll(pageable);
        }

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
    public ResultResponse<UserResponse> deleteUser(UUID id, UserDetails userDetails) {
        var userToDelete = userRepository.findById(id)
                .orElseThrow(() -> new OperationNotPermittedException("User not found with id: " + id));
        var adminUser = userRepository.findByRoles_Name(String.valueOf(RoleName.ADMIN))
                .orElseThrow(() -> new OperationNotPermittedException("Admin user not found with email: " + userDetails.getUsername()));

        if (userToDelete.getId().equals(adminUser.getId())) {
            throw new OperationNotPermittedException("Admin cannot delete themselves");
        }

        tokenRepository.deleteByUserId(id);

        userRepository.delete(userToDelete);

        try {
            emailService.sendAccountDeletionEmail(userToDelete.getEmail(), userToDelete.getUsersName(), "Your Account Has Been Deleted");
        } catch (MessagingException e) {
            log.error("Failed to send account deletion email to {}: {}", userToDelete.getEmail(), e.getMessage());
        }
        return null;
    }
}