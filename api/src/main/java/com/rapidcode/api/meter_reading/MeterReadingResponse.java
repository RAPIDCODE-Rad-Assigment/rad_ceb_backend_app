package com.rapidcode.api.meter_reading;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class MeterReadingResponse {
    private UUID id;
    private UUID meterId;
    private String meterNumber;
    private String meterReaderName;
    private String customerName;
    private String customerAddress;
    private Double readingValue;
    private LocalDateTime readingDate;
    private String meterImage;
    private String notes;
    private ReadingStatus status;

    private Double consumption;
    private Double unitPrice;
    private Double totalPrice;

    private String validationMessage;
}