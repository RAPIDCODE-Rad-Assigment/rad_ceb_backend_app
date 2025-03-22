package com.rapidcode.api.meter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeterResponse {
    private UUID id;
    private String meterNumber;
    private LocalDateTime installationDate;
    private MeterStatus status;
    private MeterUserResponse user;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
