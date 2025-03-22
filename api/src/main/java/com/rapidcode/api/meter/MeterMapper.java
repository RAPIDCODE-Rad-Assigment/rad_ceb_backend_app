package com.rapidcode.api.meter;

public class MeterMapper {
    public  static  Meter toMeter(MeterRequest meterRequest) {
        return Meter.builder()
                .meterNumber(meterRequest.meterNumber())
                .installationDate(meterRequest.installationDate())
                .status(meterRequest.status())
                .build();
    }

    public static MeterResponse toMeterResponse(Meter meter) {
        MeterUserResponse userResponse = MeterUserResponse.builder()
                .id(meter.getUser().getId())
                .usersName(meter.getUser().getUsersName())
                .email(meter.getUser().getEmail())
                .fullName(meter.getUser().getFullName())
                .address(meter.getUser().getAddress())
                .phoneNumber(meter.getUser().getPhoneNumber())
                .enabled(meter.getUser().isEnabled())
                .build();

        return MeterResponse.builder()
                .id(meter.getId())
                .meterNumber(meter.getMeterNumber())
                .installationDate(meter.getInstallationDate())
                .status(meter.getStatus())
                .user(userResponse)
                .createdDate(meter.getCreatedDate())
                .lastModifiedDate(meter.getLastModifiedDate())
                .build();

    }
}
