package com.rapidcode.api.payment;

import com.rapidcode.api.meter.Meter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String date;  // Formatted date string like "15 May 2025"
    private String title;
    private String description;
    private String icon;

    @ManyToOne
    @JoinColumn(name = "meter_id")
    private Meter meter;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}