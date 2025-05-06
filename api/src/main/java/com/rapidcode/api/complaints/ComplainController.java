package com.rapidcode.api.complaints;

import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/complaints")
@RequiredArgsConstructor
public class ComplainController {

    private final ComplainService complainService;
    // Create a complaint
    @PostMapping
    public ResultResponse<ComplaintResponse> createComplaint(
            @RequestBody ComplaintRequest complaintRequest,
            Authentication connectedUser
    ) {
        var user = ((User) connectedUser.getPrincipal());
        return complainService.createComplaint(complaintRequest, user);
    }




}