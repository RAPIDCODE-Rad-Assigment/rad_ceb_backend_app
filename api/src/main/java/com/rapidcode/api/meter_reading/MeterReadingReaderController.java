package com.rapidcode.api.meter_reading;

import com.rapidcode.api.common.PageResponse;
import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("reader/meter-readings")
@RequiredArgsConstructor
public class MeterReadingReaderController {

    private final MeterReadingService meterReadingService;

    @PostMapping
    public ResponseEntity<ResultResponse<MeterReadingResponse>> submitReading(
            @RequestBody MeterReadingRequest request,
            Authentication connectedUser) {
        var user = ((User) connectedUser.getPrincipal());
        UUID userId = user.getId();
        return ResponseEntity.ok(meterReadingService.submitReading(request, userId));

    }

    @GetMapping("/history/reader/{meterId}")
    public ResponseEntity<PageResponse<MeterReadingResponse>> getReadingHistoryForReader(
            @PathVariable UUID meterId,
            Authentication connectedUser,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        var user = ((User) connectedUser.getPrincipal());
        UUID userId = user.getId();
        return ResponseEntity.ok(meterReadingService.getReadingHistoryForReader(meterId, userId, page, size));
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
