package com.rapidcode.api.complaints;


import com.rapidcode.api.common.PageResponse;
import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.email.EmailService;
import com.rapidcode.api.user.User;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComplainService {

    private final ComplaintRepository complaintRepository;
    private final EmailService emailService;



    public ResultResponse<ComplaintResponse> createComplaint(ComplaintRequest request, User user) {
        Complaint complaint = new Complaint();
        complaint.setUser(user);
        complaint.setCategory(request.getCategory());
        complaint.setDescription(request.getDescription());
        complaint.setImageBase64List(request.getImageBase64List());
        complaint.setStatus(Complaint.Status.PENDING);
        complaint.setCreatedAt(LocalDateTime.now());

        Complaint saved = complaintRepository.save(complaint);
        ComplaintResponse response = ComplaintMapper.toResponse(saved);

        return ResultResponse.<ComplaintResponse>builder()
                .status("success")
                .data(response)
                .build();
    }

    @Transactional
    public ResultResponse<ComplaintResponse> getById(Long id) {
        Complaint complaint = complaintRepository.findByIdWithImagesAndUser(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found with id: " + id));

        ComplaintResponse response = ComplaintMapper.toResponse(complaint);

        return ResultResponse.<ComplaintResponse>builder()
                .status("success")
                .data(response)
                .build();
    }

    @Transactional(readOnly = true)
    public List<ComplaintResponse> getComplaintsByUserId(UUID userId) {
        return complaintRepository.findByUserId(userId).stream()
                .map(ComplaintMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public ResultResponse<ComplaintResponse> updateComplaint(Long id, ComplaintRequest request, User user) {
        Complaint complaint = complaintRepository.findByIdWithImagesAndUser(id)
               .orElseThrow(() -> new RuntimeException("Complaint not found"));

        complaint.setUser(user);
        complaint.setCategory(request.getCategory());
        complaint.setDescription(request.getDescription());
        complaint.setImageBase64List(request.getImageBase64List());
        complaint.setStatus(Complaint.Status.PENDING);
        complaint.setCreatedAt(LocalDateTime.now());

//        complaint.setUser(user);
//        Hibernate.initialize(complaint.getUser());
//        if (complaint.getImageBase64List() != null) {
//            Hibernate.initialize(complaint.getImageBase64List());
//        }
//        complaint.setCategory(request.getCategory());
//        complaint.setDescription(request.getDescription());
//        complaint.setStatus(Complaint.Status.PENDING);
//        complaint.setImageBase64List(request.getImageBase64List());
//        complaint.setUpdatedAt(LocalDateTime.now());

        Complaint saved = complaintRepository.save(complaint);
        ComplaintResponse response = ComplaintMapper.toResponse(saved);

        return ResultResponse.<ComplaintResponse>builder()
                .status("success")
                .data(response)
                .build();
    }

    public ResultResponse<String> deleteComplaint(Long id) {
        if (!complaintRepository.existsById(id)) {
            throw new RuntimeException("Complaint not found");
        }
        complaintRepository.deleteById(id);
        return ResultResponse.<String>builder()
                .status("success")
                .data("Meter reading deleted successfully")
                .build();
    }



    @Transactional
    public PageResponse<ComplaintResponse> getAllComplaints(
            int page, int size, Long userId, String roleName, Complaint.Status status) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        Page<Complaint> complaints = complaintRepository.findByFilters(userId, roleName, status, pageable);

        List<ComplaintResponse> content = complaints.getContent().stream()
                .map(ComplaintMapper::toResponse)
                .collect(Collectors.toList());


        return new PageResponse<>(content,
                complaints.getNumber(),
                complaints.getSize(),
                complaints.getTotalElements(),
                complaints.getTotalPages(),
                complaints.isFirst(),
                complaints.isLast());
    }


    @Transactional
    public ResultResponse<ComplaintResponse> respondToComplaint(
            Long complaintId,
            String responseMessage
            ) {

        Complaint complaint = complaintRepository.findByIdWithImagesAndUser(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        // Update complaint
        complaint.setAdminResponse(responseMessage);
        complaint.setStatus(Complaint.Status.IN_PROGRESS);
        complaint.setUpdatedAt(LocalDateTime.now());
        Complaint updated = complaintRepository.save(complaint);

        // Send email notification
        try {
            emailService.sendComplaintResponseEmail(
                    complaint.getUser().getEmail(),
                    complaint.getUser().getFullName(),
                    complaint.getDescription(),
                    responseMessage,
                    "Your Complaint Update"
            );
        } catch (MessagingException e) {
            log.error("Failed to send complaint response email", e);
        }

        return ResultResponse.<ComplaintResponse>builder()
                .status("success")
                .data(ComplaintMapper.toResponse(updated))
                .build();
    }

    @Transactional
    public ResultResponse<ComplaintResponse> changeComplaintStatus(Long complaintId, Complaint.Status status) {
        Complaint complaint = complaintRepository.findByIdWithImagesAndUser(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        complaint.setStatus(status);
        complaint.setUpdatedAt(LocalDateTime.now());
        Complaint updated = complaintRepository.save(complaint);

        return ResultResponse.<ComplaintResponse>builder()
                .status("success")
                .data(ComplaintMapper.toResponse(updated))
                .build();
    }

}
