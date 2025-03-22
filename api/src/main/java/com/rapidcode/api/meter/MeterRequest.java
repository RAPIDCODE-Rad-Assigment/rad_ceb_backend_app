package com.rapidcode.api.meter;

import java.time.LocalDateTime;

public record MeterRequest(
        String meterNumber,
        LocalDateTime installationDate,
        MeterStatus status
) {
}
