package com.rapidcode.api.user;


import com.rapidcode.api.file.FileUploadResponse;
import com.rapidcode.api.role.RoleMapper;
import com.rapidcode.api.role.RoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {
    private final ImageHelper imageHelper;

    @Autowired
    public UserMapper(ImageHelper imageHelper) {
        this.imageHelper = imageHelper;
    }

    public User updateUserFromRequest(UserRequest request, User user) {
        user.setUsersName(request.usersName());
        user.setProfile_image_url(request.profile_image_url());
        var v =  imageHelper.isImageInTempDirectory(request.profile_image_url());
        if(v){
            System.out.println("Its in ");
        }

        return user;
    }

    public UserResponse toUserResponse(User user) {
        FileUploadResponse pi;
        if (user.getProfile_image_url() != null && !user.getProfile_image_url().isEmpty()) {
            String imageUrl = imageHelper.getImageUrl(user.getProfile_image_url(), user.getId());
            pi = new FileUploadResponse(user.getProfile_image_url(), imageUrl);

        }else{
            pi = null;
        }
        List<RoleResponse> roleResponses = user.getRoles().stream()
                .map(RoleMapper::toRoleResponse)
                .toList();

        return UserResponse.builder()
                .id(user.getId())
                .usersName(user.getUsersName())
                .email(user.getEmail())
                .profile_image_url(pi)
                .enabled(user.isEnabled())
                .fullName(user.getFullName())
                .address(user.getAddress())
                .roles(roleResponses)
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
