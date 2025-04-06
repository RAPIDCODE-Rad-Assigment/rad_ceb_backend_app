package com.rapidcode.api.admin;

import com.rapidcode.api.common.PageResponse;
import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.user.User;
import com.rapidcode.api.user.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Tag(name = "Admin User")
public class AdminUserController {

    private final AdminUserServiceInterface adminUserServiceInterface;

    @PostMapping("/register_meter_reader")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<ResultResponse<UserResponse>> registerMeterReader(@RequestBody RegisterUserRequest request, Authentication connectedUser) throws MessagingException {
        var user = ((User) connectedUser.getPrincipal());
        UUID userId = user.getId();
        ResultResponse<UserResponse> response = adminUserServiceInterface.registerUser(request, userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public PageResponse<UserResponse> getAllUsersForAdmin(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String role) {
        return adminUserServiceInterface.getAllUsersForAdmin(page, size, name, role);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<ResultResponse<UserResponse>> deleteUser(@PathVariable UUID id, @AuthenticationPrincipal UserDetails userDetails) throws MessagingException {
        ResultResponse<UserResponse> response = adminUserServiceInterface.deleteUser(id, userDetails);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/readers/{userId}/areas")
    public ResponseEntity<ResultResponse<String>> removeAllAreas(
            @PathVariable UUID userId) {
        return ResponseEntity.ok(adminUserServiceInterface.removeAllAreasFromReader(userId));
    }

    @DeleteMapping("/readers/{userId}/areas/{areaId}")
    public ResponseEntity<ResultResponse<String>> removeArea(
            @PathVariable UUID userId,
            @PathVariable UUID areaId) {
        return ResponseEntity.ok(adminUserServiceInterface.removeAreaFromReader(userId, areaId));
    }
}