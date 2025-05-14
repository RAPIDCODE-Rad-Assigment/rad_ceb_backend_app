package com.rapidcode.api.payment;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PaymentRequest {
    private UUID readingId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}