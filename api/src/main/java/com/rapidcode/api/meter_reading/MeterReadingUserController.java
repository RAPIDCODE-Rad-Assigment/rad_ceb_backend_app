package com.rapidcode.api.meter_reading;

import com.rapidcode.api.common.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user/meter-readings")
@RequiredArgsConstructor
public class MeterReadingUserController {

    private final MeterReadingService meterReadingService;

    @GetMapping("/meter/{meterId}")
    public ResponseEntity<PageResponse<MeterReadingResponse>> getMeterReadingsByMeterId(
            @PathVariable UUID meterId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(meterReadingService.getMeterReadingsByMeterId(meterId, page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageResponse<MeterReadingResponse>> getMeterReadingById(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(meterReadingService.getMeterReadingById(id));
    }

    @GetMapping("/history/{meterId}")
    public ResponseEntity<PageResponse<MeterReadingResponse>> getReadingHistoryForMeter(
            @PathVariable UUID meterId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(meterReadingService.getReadingHistory(meterId, page, size));
    }
}