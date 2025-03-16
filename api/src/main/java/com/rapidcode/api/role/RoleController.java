package com.rapidcode.api.role;

import com.rapidcode.api.common.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    @GetMapping
    public ResponseEntity<ResultResponse<List<RoleResponse>>> getAllRoles() {
        ResultResponse<List<RoleResponse>> response = roleService.getAllRoles();
        return ResponseEntity.ok(response);
    }

    // Get a role by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResultResponse<RoleResponse>> getRoleById(@PathVariable Integer id) {
        ResultResponse<RoleResponse> response = roleService.getRoleById(id);
        return ResponseEntity.ok(response);
    }


}