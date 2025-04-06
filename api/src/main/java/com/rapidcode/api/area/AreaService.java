package com.rapidcode.api.area;

import com.rapidcode.api.common.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;


    public ResultResponse<Area> createArea(AreaRequest request) {
        if (areaRepository.existsByName(request.getName())) {
            throw new RuntimeException("Area with this name already exists");
        }

        Area area = Area.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        Area savedArea = areaRepository.save(area);
        return ResultResponse.<Area>builder()
                .status("success")
                .data(savedArea)
                .build();
    }

    public ResultResponse<AreaResponse> getAreaById(UUID id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Area not found"));
        return ResultResponse.<AreaResponse>builder()
                .status("success")
                .data(areaMapper.toAreaResponse(area))
                .build();
    }

    public ResultResponse<List<AreaResponse>> getAllAreas() {
        List<Area> areas = areaRepository.findAll();
        return ResultResponse.<List<AreaResponse>>builder()
                .status("success")
                .data(areas.stream().map(areaMapper::toAreaResponse).toList())
                .build();
    }


    public ResultResponse<Area> updateArea(UUID id, AreaRequest request) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Area not found"));

        if (!area.getName().equals(request.getName()) &&
                areaRepository.existsByName(request.getName())) {
            throw new RuntimeException("Area with this name already exists");
        }

        area.setName(request.getName());
        area.setDescription(request.getDescription());

        Area updatedArea = areaRepository.save(area);
        return ResultResponse.<Area>builder()
                .status("success")
                .data(updatedArea)
                .build();
    }

    public ResultResponse<String> deleteArea(UUID id) {
        if (!areaRepository.existsById(id)) {
            throw new RuntimeException("Area not found");
        }

        areaRepository.deleteById(id);
        return ResultResponse.<String>builder()
                .status("success")
                .data("Area deleted successfully")
                .build();
    }
}