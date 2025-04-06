package com.rapidcode.api.meter_reading;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PricingInfo {
    private Double unitPrice;
    private Double totalPrice;
}
