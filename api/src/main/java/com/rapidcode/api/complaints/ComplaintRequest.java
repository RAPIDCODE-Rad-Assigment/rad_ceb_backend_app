package com.rapidcode.api.complaints;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplaintRequest {

    private Complaint.Category category;

    @NotEmpty(message = "Description is required")
    private String description;

    private List<String> imageBase64List;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Contact is required")
    private String contact;

    @NotEmpty(message = "Location is required")
    private String location;
}
