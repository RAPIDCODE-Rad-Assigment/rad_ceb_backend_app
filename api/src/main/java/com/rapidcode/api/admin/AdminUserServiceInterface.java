package com.rapidcode.api.admin;

import com.rapidcode.api.common.PageResponse;
import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.user.UserResponse;
import jakarta.mail.MessagingException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface AdminUserServiceInterface {
    ResultResponse<UserResponse> registerUser(RegisterUserRequest request) throws MessagingException;
    PageResponse<UserResponse> getAllUsersForAdmin(int page, int size, String name, String role);
    ResultResponse<UserResponse> deleteUser(UUID id, UserDetails userDetails);

}
