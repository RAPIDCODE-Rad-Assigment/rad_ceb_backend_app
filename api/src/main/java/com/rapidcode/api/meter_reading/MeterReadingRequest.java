package com.rapidcode.api.meter_reading;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.UUID;

@Data
public class MeterReadingRequest {

    @NotNull
    private UUID meterId;

    @Positive
    private Double readingValue;

    private String notes;

    @NotBlank
    private String meterImage; // Base64 encoded image
}
