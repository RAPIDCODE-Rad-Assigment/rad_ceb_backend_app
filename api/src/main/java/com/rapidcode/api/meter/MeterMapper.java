package com.rapidcode.api.meter;

import com.rapidcode.api.area.Area;
import com.rapidcode.api.area.AreaResponse;

public class MeterMapper {
    public  static  Meter toMeter(MeterRequest meterRequest) {
        return Meter.builder()
                .meterNumber(meterRequest.meterNumber())
                .installationDate(meterRequest.installationDate())
                .status(meterRequest.status())
                .build();
    }

    public static MeterResponse toMeterResponse(Meter meter) {
        Area area = meter.getArea();

        MeterUserResponse userResponse = MeterUserResponse.builder()
                .id(meter.getUser().getId())
                .usersName(meter.getUser().getUsersName())
                .email(meter.getUser().getEmail())
                .fullName(meter.getUser().getFullName())
                .address(meter.getUser().getAddress())
                .phoneNumber(meter.getUser().getPhoneNumber())
                .enabled(meter.getUser().isEnabled())
                .build();

        AreaResponse areaResponse = AreaResponse.builder()
                .id(area.getId())
                .name(area.getName())
                .description(area.getDescription())
                .build();

        return MeterResponse.builder()
                .id(meter.getId())
                .meterNumber(meter.getMeterNumber())
                .installationDate(meter.getInstallationDate())
                .status(meter.getStatus())
                .user(userResponse)
                .area(areaResponse)
                .createdDate(meter.getCreatedDate())
                .lastModifiedDate(meter.getLastModifiedDate())
                .build();

    }
}
