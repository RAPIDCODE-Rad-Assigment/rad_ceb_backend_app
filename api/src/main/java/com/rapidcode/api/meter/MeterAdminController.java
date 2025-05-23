package com.rapidcode.api.meter;

import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("admin/meter")
@Tag(name = "Meter", description = "Meter Management APIs")
@RequiredArgsConstructor
public class MeterAdminController {

    private final MeterService service;

    @GetMapping("/{meterId}")
    @Operation(summary = "Get Meter by ID", description = "Retrieves a meter by its unique ID.")
    public ResultResponse<MeterResponse> getMeterById(@PathVariable UUID meterId) {
        return service.getMeterById(meterId);
    }

    @DeleteMapping("/{meterId}")
    @Operation(summary = "Delete Meter by ID", description = "Deletes a meter by its unique ID.")
    public ResultResponse<String> deleteMeter(@PathVariable UUID meterId) {
        return service.deleteMeter(meterId);
    }

    @GetMapping
    @Operation(summary = "Get All Meters", description = "Retrieves all meters with pagination and filtering.")
    public ResultResponse<List<MeterResponse>> getAllMeters(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdDate") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDir,
            @RequestParam(required = false) MeterStatus status,
            @RequestParam(required = false) String userName // Add this parameter
    ) {
        return service.getAllMeters(page, size, sortBy, sortDir, status, userName);
    }

}