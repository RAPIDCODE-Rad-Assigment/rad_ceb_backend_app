package com.rapidcode.api.payment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/checkout")
    public ResponseEntity<String> initiatePayment(@Valid @RequestBody PaymentRequest request) {
        try {
            String response = paymentService.initiatePayment(request);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error initiating payment: " + e.getMessage());
        }
    }
    @PostMapping("/notify")
    public ResponseEntity<String> handlePaymentNotification(@RequestParam Map<String, String> params) {
        paymentService.handlePaymentNotification(params);
        return ResponseEntity.ok("Payment notification received");
    }

}