package com.rapidcode.api.meter_reading;

import com.rapidcode.api.meter.Meter;
import com.rapidcode.api.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "meter_readings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meter_id", nullable = false)
    private Meter meter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User reader;

    private Double readingValue;
    private LocalDateTime readingDate;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String meterImage;

    private String notes;
    private ReadingStatus status;

    @CreatedDate
    private LocalDateTime createdDate;

    private Double consumption;
    private Double unitPrice;
    private Double totalPrice;

}
