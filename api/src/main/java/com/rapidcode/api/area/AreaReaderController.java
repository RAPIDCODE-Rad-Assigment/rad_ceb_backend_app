package com.rapidcode.api.area;

import com.rapidcode.api.common.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("reader/areas")
@RequiredArgsConstructor
public class AreaReaderController {

    private final AreaService areaService;

    @GetMapping("/{id}")
    public ResultResponse<AreaResponse> getAreaById(@PathVariable UUID id) {
        return areaService.getAreaById(id);
    }

    @GetMapping
    public ResultResponse<List<AreaResponse>> getAllAreas() {
        return areaService.getAllAreas();
    }

}