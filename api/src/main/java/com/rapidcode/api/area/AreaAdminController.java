package com.rapidcode.api.area;

import com.rapidcode.api.common.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("admin/areas")
@RequiredArgsConstructor
public class AreaAdminController {

    private final AreaService areaService;

    @PostMapping
    public ResultResponse<Area> createArea(@RequestBody AreaRequest request) {
        return areaService.createArea(request);
    }

    @GetMapping("/{id}")
    public ResultResponse<AreaResponse> getAreaById(@PathVariable UUID id) {
        return areaService.getAreaById(id);
    }

    @GetMapping
    public ResultResponse<List<AreaResponse>> getAllAreas() {
        return areaService.getAllAreas();
    }

    @PutMapping("/{id}")
    public ResultResponse<Area> updateArea(
            @PathVariable UUID id,
            @RequestBody AreaRequest request) {
        return areaService.updateArea(id, request);
    }

    @DeleteMapping("/{id}")
    public ResultResponse<String> deleteArea(@PathVariable UUID id) {
        return areaService.deleteArea(id);
    }
}