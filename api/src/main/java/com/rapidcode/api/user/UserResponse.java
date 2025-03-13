package com.rapidcode.api.user;

import com.rapidcode.api.file.FileUploadResponse;
import lombok.*;

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
    private FileUploadResponse profile_image_url;
    private boolean enabled;

}
