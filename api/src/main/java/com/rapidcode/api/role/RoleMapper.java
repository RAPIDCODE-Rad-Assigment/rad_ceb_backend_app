package com.rapidcode.api.role;

import java.util.Set;

public class RoleMapper {

    public static RoleResponse toRoleResponse(Role role) {
        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .permissions(role.getPermissions())
                .createdDate(role.getCreatedDate())
                .lastModifiedDate(role.getLastModifiedDate())
                .build();
    }
}