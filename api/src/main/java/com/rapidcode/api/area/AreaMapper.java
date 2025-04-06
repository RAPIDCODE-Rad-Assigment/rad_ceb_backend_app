package com.rapidcode.api.area;

import org.springframework.stereotype.Component;

@Component
public class AreaMapper {
    public AreaResponse toAreaResponse(Area area) {
        return AreaResponse.builder()
                .id(area.getId())
                .name(area.getName())
                .description(area.getDescription())
                .build();
    }
}