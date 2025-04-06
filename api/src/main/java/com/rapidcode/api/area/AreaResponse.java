package com.rapidcode.api.area;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AreaResponse {
    private UUID id;
    private String name;
    private String description;
}