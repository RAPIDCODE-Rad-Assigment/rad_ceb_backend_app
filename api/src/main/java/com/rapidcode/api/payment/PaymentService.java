package com.rapidcode.api.payment;

import com.rapidcode.api.meter.MeterRepository;
import com.rapidcode.api.meter_reading.MeterReading;
import com.rapidcode.api.meter_reading.MeterReadingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.math.BigInteger;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final MeterRepository meterRepository;
    private final MeterReadingRepository meterReadingRepository;
    private final RestTemplate restTemplate;


    @Value("${application.payhere.sandbox-url}")
    private String sandboxUrl;

    @Value("${application.payhere.merchant-secret}")
    private String merchantSecret;

    @Value("${application.payhere.merchant-id}")
    private String merchantId;

    @Value("${application.payhere.notify-url}")
    private String notifyUrl;

    @Value("${application.payhere.return-url}")
    private String returnUrl;

    @Value("${application.payhere.cancel-url}")
    private String cancelUrl;


    @Transactional
    public String initiatePayment(PaymentRequest request) {
        MeterReading reading = meterReadingRepository.findById(request.getReadingId())
                .orElseThrow(() -> new RuntimeException("Meter reading not found"));

        String orderId = "MR-" + reading.getId().toString().substring(0, 8);
        String amountFormatted = new DecimalFormat("0.00").format(reading.getTotalPrice());
        String currency = "LKR";

        String hash = generateMd5(merchantId + orderId + amountFormatted + currency + generateMd5(merchantSecret));

        PayhereRequestDto requestDto = new PayhereRequestDto();
        requestDto.setSandbox("true");
        requestDto.setMerchant_id(merchantId);
        requestDto.setReturn_url(returnUrl);
        requestDto.setCancel_url(cancelUrl);
        requestDto.setNotify_url(notifyUrl);
        requestDto.setFirst_name(request.getFirstName());
        requestDto.setLast_name(request.getLastName());
        requestDto.setEmail(request.getEmail());
        requestDto.setPhone(request.getPhone());
        requestDto.setAddress(request.getAddress());
        requestDto.setCity("");
        requestDto.setCountry("Sri Lanka");
        requestDto.setOrder_id(orderId);
        requestDto.setItems("Electricity Bill - " + reading.getMeter().getMeterNumber());
        requestDto.setCurrency(currency);
        requestDto.setAmount(amountFormatted);
        requestDto.setHash(hash);

        String formBody = encodeToFormString(requestDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> entity = new HttpEntity<>(formBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    URI.create(sandboxUrl),
                    HttpMethod.POST,
                    entity,
                    String.class
            );

            log.info("Payment response: {}", response.getBody());
            return response.getBody();

        } catch (Exception e) {
            log.error("Error occurred while sending payment request", e);
            return "Error occurred while sending payment request: " + e.getMessage();
        }
    }






    private String encodeToFormString(PayhereRequestDto requestDto) {
        return "sandbox=" + URLEncoder.encode(requestDto.getSandbox(), StandardCharsets.UTF_8) + "&" +
                "merchant_id=" + URLEncoder.encode(requestDto.getMerchant_id(), StandardCharsets.UTF_8) + "&" +
                "return_url=" + URLEncoder.encode(requestDto.getReturn_url(), StandardCharsets.UTF_8) + "&" +
                "cancel_url=" + URLEncoder.encode(requestDto.getCancel_url(), StandardCharsets.UTF_8) + "&" +
                "notify_url=" + URLEncoder.encode(requestDto.getNotify_url(), StandardCharsets.UTF_8) + "&" +
                "first_name=" + URLEncoder.encode(requestDto.getFirst_name(), StandardCharsets.UTF_8) + "&" +
                "last_name=" + URLEncoder.encode(requestDto.getLast_name(), StandardCharsets.UTF_8) + "&" +
                "email=" + URLEncoder.encode(requestDto.getEmail(), StandardCharsets.UTF_8) + "&" +
                "phone=" + URLEncoder.encode(requestDto.getPhone(), StandardCharsets.UTF_8) + "&" +
                "address=" + URLEncoder.encode(requestDto.getAddress(), StandardCharsets.UTF_8) + "&" +
                "city=" + URLEncoder.encode(requestDto.getCity(), StandardCharsets.UTF_8) + "&" +
                "country=" + URLEncoder.encode(requestDto.getCountry(), StandardCharsets.UTF_8) + "&" +
                "order_id=" + URLEncoder.encode(requestDto.getOrder_id(), StandardCharsets.UTF_8) + "&" +
                "items=" + URLEncoder.encode(requestDto.getItems(), StandardCharsets.UTF_8) + "&" +
                "currency=" + URLEncoder.encode(requestDto.getCurrency(), StandardCharsets.UTF_8) + "&" +
                "amount=" + URLEncoder.encode(requestDto.getAmount(), StandardCharsets.UTF_8) + "&" +
                "hash=" + URLEncoder.encode(requestDto.getHash(), StandardCharsets.UTF_8);
    }

    public String generateMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);

            // Pad with leading zeros to ensure 32 characters
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating MD5 hash: " + e.getMessage(), e);
        }
    }

    @Transactional
    public void handlePaymentNotification(Map<String, String> params) {
        if (!verifyPayment(params)) {
            throw new RuntimeException("Invalid payment signature");
        }

        String orderId = params.get("order_id");
        String paymentId = params.get("payment_id");
        String status = params.get("status_code");

        // Extract reading ID from order ID (MR-<readingId>)
        String readingIdStr = orderId.substring(3);
        UUID readingId = UUID.fromString(readingIdStr);

        MeterReading reading = meterReadingRepository.findById(readingId)
                .orElseThrow(() -> new RuntimeException("Meter reading not found"));

        // Update payment details

        reading.setPaymentDoneAt(LocalDateTime.now());

        meterReadingRepository.save(reading);
    }

    private boolean verifyPayment(Map<String, String> params) {
        try {
            String receivedHash = params.get("hash");
            String verificationString = String.join("|",
                    params.get("merchant_id"),
                    params.get("order_id"),
                    params.get("payhere_amount"),
                    params.get("payhere_currency"),
                    params.get("status_code"),
                    merchantSecret
            );

            String computedHash = generateMd5(verificationString);
            return computedHash.equals(receivedHash);
        } catch (Exception e) {
            log.error("Payment verification failed", e);
            return false;
        }
    }
}



