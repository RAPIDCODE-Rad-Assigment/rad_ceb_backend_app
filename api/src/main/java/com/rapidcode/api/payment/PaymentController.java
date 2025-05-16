package com.rapidcode.api.payment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
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
    @PostMapping(value = "/notify", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> handlePaymentNotification(@RequestParam Map<String, String> formParams) {
        try {
            paymentService.handlePaymentNotification(formParams);
            return ResponseEntity.ok("Payment notification received");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error processing payment notification: " + e.getMessage());
        }
    }


//    @PostMapping("/notify")
//    public ResponseEntity<String> testNotify() {
//        return ResponseEntity.ok("Hello World! Notify is working.");
//    }


    @GetMapping("/return")
    public ResponseEntity<String> handlePaymentSuccess() {
        return ResponseEntity.ok("Payment notification received");
    }

    @GetMapping("/cancel")
    public ResponseEntity<String> handlePaymentCancel() {
        return ResponseEntity.ok("Payment notification cancel");
    }

}