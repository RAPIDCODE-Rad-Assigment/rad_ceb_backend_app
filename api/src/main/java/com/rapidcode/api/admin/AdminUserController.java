package com.rapidcode.api.admin;

import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.user.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Tag(name = "Admin User")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @PostMapping("/register_user")
    public ResponseEntity<ResultResponse<UserResponse>> registerUser(@RequestBody RegisterUserRequest request) throws MessagingException {
        ResultResponse<UserResponse> response = adminUserService.registerUser(request);
        return ResponseEntity.ok(response);
    }
}