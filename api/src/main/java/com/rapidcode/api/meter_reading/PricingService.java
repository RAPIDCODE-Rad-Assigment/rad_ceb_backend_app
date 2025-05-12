package com.rapidcode.api.meter_reading;

import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PricingService {

    @org.springframework.beans.factory.annotation.Value("${application.pricing.base-rate}")
    private double baseRate;

    @org.springframework.beans.factory.annotation.Value("${application.pricing.tax-rate}")
    private double taxRate;

    public PricingInfo calculatePrice(Double consumption) {
        double safeConsumption = Optional.ofNullable(consumption).orElse(0.0);

        if (safeConsumption <= 0) {
            return PricingInfo.builder()
                    .unitPrice(baseRate)
                    .totalPrice(0.0)
                    .build();
        }

        double totalBeforeTax = safeConsumption * baseRate;
        double taxAmount = totalBeforeTax * taxRate;
        double totalPrice = totalBeforeTax + taxAmount;

        return PricingInfo.builder()
                .unitPrice(baseRate)
                .totalPrice(totalPrice)
                .build();
    }
}