package com.rapidcode.api.meter_reading;

import org.springframework.stereotype.Component;

@Component
public class MeterReadingMapper {

    public MeterReadingResponse toResponse(MeterReading reading) {
        return MeterReadingResponse.builder()
                .id(reading.getId())
                .meterId(reading.getMeter().getId())
                .meterNumber(reading.getMeter().getMeterNumber())
                .meterReaderName(reading.getMeter().getUser().getUsersName())
                .customerName(reading.getMeter().getUser().getFullName())
                .customerAddress(reading.getMeter().getUser().getAddress())
                .readingValue(reading.getReadingValue())
                .readingDate(reading.getReadingDate())
                .meterImage(reading.getMeterImage())
                .notes(reading.getNotes())
                .status(reading.getStatus())
                .consumption(reading.getConsumption())
                .unitPrice(reading.getUnitPrice())
                .totalPrice(reading.getTotalPrice())
                .build();
    }
}
