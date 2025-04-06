package com.rapidcode.api.meter;

import java.time.LocalDateTime;
import java.util.UUID;

public record MeterRequest(
        String meterNumber,
        LocalDateTime installationDate,
        MeterStatus status,
        UUID areaId

) {
}
