package com.rapidcode.api.complaints;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ComplaintResponse {
    private Long id;
    private String description;
    private Complaint.Status status;
    private String category;
    private LocalDateTime createdAt;
    private UserInfo user;
    private List<String> imageBase64List;
    private String name;
    private String contact;
    private String location;


    @Data
    public static class UserInfo {
        private UUID id;
        private String name;
        private String email;
        private String role;
    }
}