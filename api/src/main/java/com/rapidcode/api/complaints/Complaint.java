package com.rapidcode.api.complaints;

import com.rapidcode.api.role.Role;
import com.rapidcode.api.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String RoleName;

    @ManyToOne(fetch = FetchType.LAZY) // or EAGER if you prefer
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ElementCollection
    @CollectionTable(name = "complaint_images", joinColumns = @JoinColumn(name = "complaint_id"))
    @Column(name = "image_base64", columnDefinition = "TEXT")
    private List<String> imageBase64List;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(columnDefinition = "TEXT")
    private String adminResponse;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = Status.PENDING;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum Category {
        BILLING, TECHNICAL, OTHER
    }

    public enum Status {
        PENDING, IN_PROGRESS, RESOLVED, REJECTED
    }
}
