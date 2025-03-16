package com.rapidcode.api.admin;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String username;
    private String email;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Integer roleId;
}
