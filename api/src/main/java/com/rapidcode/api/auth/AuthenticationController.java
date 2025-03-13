package com.rapidcode.api.auth;

import com.rapidcode.api.user.ForgotPasswordRequest;
import com.rapidcode.api.user.UserStatusChangeRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthenticationService service;

    @Autowired
    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @Valid
            @RequestBody RegisterRequest request

    ) throws MessagingException {

        return ResponseEntity.ok(service.register(request));

    }

    // Helper method to build validation error response
    private Map<String, String> buildValidationErrors(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(fieldError ->
                errors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return errors;
    }


    @PostMapping("/forgot-password")
    public ResponseEntity<Map<String, Object>> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) throws Exception {
        service.processForgotPassword(request.email());
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Password reset email sent if the email exists.");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Map<String, Object>> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        Map<String, Object> response = new HashMap<>();
        try {
            service.resetPassword(token, newPassword);
            response.put("message", "Password has been reset");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @Valid
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }


    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }

    @GetMapping("/activate-account")
    public void confirm(
            @RequestParam String token
    ) throws MessagingException {
        service.activateAccount(token);
    }


    @PostMapping("/resend-activation")
    public ResponseEntity<String> resendActivationCode(@RequestBody UserStatusChangeRequest request) throws MessagingException {
        service.resendActivationCode(request.email());
        return ResponseEntity.ok("Activation code resent successfully");
    }

}