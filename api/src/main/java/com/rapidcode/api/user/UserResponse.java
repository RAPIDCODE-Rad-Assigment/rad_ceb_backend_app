package com.rapidcode.api.user;

import com.rapidcode.api.file.FileUploadResponse;
import com.rapidcode.api.role.RoleResponse;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private UUID id;
    private String usersName;
    private String email;
    private String fullName;
    private String address;
    private String phoneNumber;
    private FileUploadResponse profile_image_url;
    private boolean enabled;
    private List<RoleResponse> roles;

}
