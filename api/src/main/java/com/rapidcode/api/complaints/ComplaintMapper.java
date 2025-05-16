package com.rapidcode.api.complaints;

import com.rapidcode.api.user.User;
import com.rapidcode.api.role.Role;

import java.util.stream.Collectors;

public class ComplaintMapper {

    public static ComplaintResponse toResponse(Complaint complaint) {
        ComplaintResponse response = new ComplaintResponse();
        response.setId(complaint.getId());
        response.setDescription(complaint.getDescription());
        response.setStatus(complaint.getStatus());
        response.setCategory(String.valueOf(complaint.getCategory()));
        response.setCreatedAt(complaint.getCreatedAt());
        response.setImageBase64List(complaint.getImageBase64List());
        response.setName(complaint.getName());
        response.setContact(complaint.getContact());
        response.setLocation(complaint.getLocation());

        User user = complaint.getUser();
        if (user != null) {
            ComplaintResponse.UserInfo userInfo = new ComplaintResponse.UserInfo();
            userInfo.setId(user.getId());
            userInfo.setName(user.getFullName());
            userInfo.setEmail(user.getEmail());

            String roleNames = user.getRoles()
                    .stream()
                    .map(Role::getName)
                    .collect(Collectors.joining(", "));
            userInfo.setRole(roleNames);

            response.setUser(userInfo);
        }

        return response;
    }
}