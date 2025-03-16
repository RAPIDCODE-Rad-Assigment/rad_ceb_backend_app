package com.rapidcode.api.admin;

import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.role.Role;
import com.rapidcode.api.role.RoleRepository;
import com.rapidcode.api.user.User;
import com.rapidcode.api.user.UserMapper;
import com.rapidcode.api.user.UserRepository;
import com.rapidcode.api.user.UserResponse;
import com.rapidcode.api.util.UserUtils;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserUtils userUtils;

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
}