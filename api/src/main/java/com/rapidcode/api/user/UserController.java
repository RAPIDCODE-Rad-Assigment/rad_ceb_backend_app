package com.rapidcode.api.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("users")
@Tag(name = "User")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PatchMapping("/change_password")
    @PreAuthorize("hasAuthority('admin:update') or hasAuthority('user:update')")
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/disable_user")
    @PreAuthorize("hasAuthority('admin:update') or hasAuthority('user:update')")
    public ResponseEntity<Boolean> disableUser(@RequestBody UserStatusChangeRequest disableUserRequest) throws Exception {
        service.disableUser(disableUserRequest);
        return ResponseEntity.ok(Boolean.TRUE);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:update') or hasAuthority('user:update')")
    public ResponseEntity<UserResponse> updateUserProfile(@PathVariable UUID id, @RequestBody UserRequest updateRequest) {
        UserResponse response = service.updateUserProfile(id, updateRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('user:read')")
    public UserResponse getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return service.getCurrentUser(userDetails);
    }
}