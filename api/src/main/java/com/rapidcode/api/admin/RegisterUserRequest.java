package com.rapidcode.api.admin;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "users name is required")
    private String username;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "full name is required")
    private String fullName;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "phone number is required")
    private String phoneNumber;

    private Integer roleId;
}
