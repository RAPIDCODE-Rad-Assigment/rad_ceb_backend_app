package com.rapidcode.api.complaints;

import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/complaints/user")  // Change here to make it more specific
@RequiredArgsConstructor
public class UserReaderComplaintController {

    private final ComplainService complainService;

    @PostMapping
    public ResultResponse<ComplaintResponse> createComplaint(
            @RequestBody ComplaintRequest complaintRequest,
            Authentication connectedUser
    ) {
        var user = ((User) connectedUser.getPrincipal());
        return complainService.createComplaint(complaintRequest, user);
    }

    @GetMapping("/{id}")
    public ResultResponse<ComplaintResponse> getComplaintById(@PathVariable Long id) {
        return complainService.getById(id);
    }

    @GetMapping("/user/{userId}")
    public List<ComplaintResponse> getComplaintsByUserId(@PathVariable UUID userId) {
        return complainService.getComplaintsByUserId(userId);
    }

    @PutMapping("/{id}")
    public ResultResponse<ComplaintResponse> updateComplaint(
            @PathVariable Long id,
            @RequestBody @Valid ComplaintRequest complaintRequest,
            Authentication connectedUser
    ) {
        var user = ((User) connectedUser.getPrincipal());
        return complainService.updateComplaint(id, complaintRequest, user);
    }

    @DeleteMapping("/{id}")
    public ResultResponse<String> deleteComplaint(@PathVariable Long id) {
        return complainService.deleteComplaint(id);
    }
}