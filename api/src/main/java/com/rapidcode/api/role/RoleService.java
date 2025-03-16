package com.rapidcode.api.role;

import com.rapidcode.api.common.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    public ResultResponse<List<RoleResponse>> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleResponse> roleResponses = roles.stream()
                .map(RoleMapper::toRoleResponse)
                .collect(Collectors.toList());
        return ResultResponse.<List<RoleResponse>>builder()
                .status("success")
                .data(roleResponses)
                .build();
    }

    public ResultResponse<RoleResponse> getRoleById(Integer id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        RoleResponse roleResponse = RoleMapper.toRoleResponse(role);
        return ResultResponse.<RoleResponse>builder()
                .status("success")
                .data(roleResponse)
                .build();
    }

}