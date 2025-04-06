package com.rapidcode.api.admin;

import com.rapidcode.api.area.Area;
import com.rapidcode.api.area.AreaRepository;
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
import java.util.stream.Collectors;

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
    private final AreaRepository areaRepository;


    @Transactional
    @Override
    public ResultResponse<UserResponse> registerUser(RegisterUserRequest request, UUID userId) throws MessagingException {
        // Check if role is METER_READER
        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        if (!role.getName().equals(RoleName.METER_READER.name())) {
            throw new OperationNotPermittedException("Operation not permitted");
        }
        if (request.getAreaIds() != null && !request.getAreaIds().isEmpty()) {
            List<User> existingReaders = userRepository.findUsersByAssignedAreaIds(request.getAreaIds());
            if (!existingReaders.isEmpty()) {

                List<Area> occupiedAreas = areaRepository.findAllById(
                        existingReaders.stream()
                                .flatMap(user -> user.getAssignedAreas().stream())
                                .map(Area::getId)
                                .distinct()
                                .filter(request.getAreaIds()::contains)
                                .toList()
                );

                String areaNames = occupiedAreas.stream()
                        .map(Area::getName)
                        .collect(Collectors.joining(", "));

                throw new OperationNotPermittedException(
                        "Areas already assigned to other readers: " + areaNames);
            }
        }

        String rawPassword = UUID.randomUUID().toString();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        List<Area> areas = request.getAreaIds() != null && !request.getAreaIds().isEmpty()
                ? areaRepository.findAllById(request.getAreaIds())
                : List.of();

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
                .assignedAreas(areas)
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





    @Transactional
    public ResultResponse<String> removeAllAreasFromReader(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (isMeterReader(user)) {
            throw new OperationNotPermittedException("Only meter readers can have areas removed");
        }

        userRepository.clearAllUserAreaAssignments(userId);
        return ResultResponse.<String>builder()
                .status("success")
                .data("All areas removed from meter reader")
                .build();
    }

    @Transactional
    public ResultResponse<String> removeAreaFromReader(UUID userId, UUID areaId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Area area = areaRepository.findById(areaId)
                .orElseThrow(() -> new RuntimeException("Area not found"));

        if (isMeterReader(user)) {
            throw new OperationNotPermittedException("Only meter readers can have areas removed");
        }

        if (!user.getAssignedAreas().contains(area)) {
            throw new OperationNotPermittedException("User is not assigned to this area");
        }

        userRepository.removeUserAreaAssignment(userId, areaId);
        return ResultResponse.<String>builder()
                .status("success")
                .data("Area removed from meter reader")
                .build();
    }

    private boolean isMeterReader(User user) {
        return user.getRoles().stream()
                .noneMatch(role -> role.getName().equals(RoleName.METER_READER.name()));
    }
}