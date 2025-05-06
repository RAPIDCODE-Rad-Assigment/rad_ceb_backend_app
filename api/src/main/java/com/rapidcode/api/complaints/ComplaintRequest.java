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
    @NotEmpty(message = "Category is required")
    private Complaint.Category category;

    @NotEmpty(message = "Description is required")
    private String description;

    private List<String> imageBase64List;

}