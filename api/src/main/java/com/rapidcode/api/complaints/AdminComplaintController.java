package com.rapidcode.api.complaints;

import com.rapidcode.api.common.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/complaints")
@RequiredArgsConstructor
public class AdminComplaintController {
    private final ComplainService complainService;

    // Get All Complaints
    @GetMapping
    public PageResponse<ComplaintResponse> getAllComplaints(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String roleName,
            @RequestParam(required = false) Complaint.Status status) {
        return complainService.getAllComplaints(page, size, userId, roleName, status);
    }
}