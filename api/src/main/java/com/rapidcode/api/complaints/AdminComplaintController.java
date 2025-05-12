package com.rapidcode.api.complaints;

import com.rapidcode.api.common.PageResponse;
import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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



    @PostMapping("/{complaintId}/respond")
    public ResponseEntity<ResultResponse<ComplaintResponse>> respondToComplaint(
            @PathVariable Long complaintId,
            @RequestBody String responseMessage
            ) {



        return ResponseEntity.ok(
                complainService.respondToComplaint(complaintId, responseMessage)
        );
    }

    @PostMapping("/{complaintId}/chage_status")
    public ResponseEntity<ResultResponse<ComplaintResponse>> changeComplaintStatus(
            @PathVariable Long complaintId,
            @RequestParam(required = false) Complaint.Status status
            ) {
        return ResponseEntity.ok(
                complainService.changeComplaintStatus(complaintId, status)
        );
    }

}