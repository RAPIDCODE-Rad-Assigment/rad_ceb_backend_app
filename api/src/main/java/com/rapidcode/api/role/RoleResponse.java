package com.rapidcode.api.role;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class RoleResponse {
    private Integer id;
    private String name;
    private Set<Permission> permissions;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
