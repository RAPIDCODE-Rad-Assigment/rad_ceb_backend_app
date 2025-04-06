package com.rapidcode.api.meter_reading;

import com.rapidcode.api.common.PageResponse;
import com.rapidcode.api.common.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("admin/meter-readings")
@RequiredArgsConstructor
public class MeterReadingAdminController {

    private final MeterReadingService meterReadingService;

    @GetMapping
    public ResponseEntity<PageResponse<MeterReadingResponse>> getAllMeterReadings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(meterReadingService.getAllMeterReadings(page, size));
    }

    @GetMapping("/meter/{meterId}")
    public ResponseEntity<PageResponse<MeterReadingResponse>> getMeterReadingsByMeterId(
            @PathVariable UUID meterId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(meterReadingService.getMeterReadingsByMeterId(meterId, page, size));
    }

    @GetMapping("/history/{meterId}")
    public ResponseEntity<PageResponse<MeterReadingResponse>> getReadingHistoryForMeter(
            @PathVariable UUID meterId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(meterReadingService.getReadingHistory(meterId, page, size));
    }

    @DeleteMapping("/{readingId}")
    public ResponseEntity<ResultResponse<String>> deleteMeterReading(
            @PathVariable UUID readingId) {
        return ResponseEntity.ok(meterReadingService.deleteMeterReading(readingId));
    }
}
