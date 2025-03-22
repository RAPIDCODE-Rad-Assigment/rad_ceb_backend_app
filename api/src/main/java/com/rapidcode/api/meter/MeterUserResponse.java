package com.rapidcode.api.meter;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeterUserResponse {
    private UUID id;
    private String usersName;
    private String email;
    private String fullName;
    private String address;
    private String phoneNumber;
    private boolean enabled;
}
