package com.rapidcode.api.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ForgotPasswordRequest(
        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Email should be valid")
        String email
) {
}