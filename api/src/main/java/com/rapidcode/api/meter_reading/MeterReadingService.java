package com.rapidcode.api.meter_reading;

import com.rapidcode.api.common.PageResponse;
import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.handler.OperationNotPermittedException;
import com.rapidcode.api.meter.Meter;
import com.rapidcode.api.meter.MeterRepository;
import com.rapidcode.api.user.User;
import com.rapidcode.api.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MeterReadingService {
    private final MeterRepository meterRepository;
    private final MeterReadingRepository meterReadingRepository;
    private final UserRepository userRepository;
    private final MeterReadingMapper meterReadingMapper;
//    private final NotificationService notificationService;
    private final PricingService pricingService;


    @Transactional
    public ResultResponse<MeterReadingResponse> submitReading(MeterReadingRequest request, UUID userId) {

        User reader = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Meter reader not found"));

        Meter meter = meterRepository.findByIdWithUser(request.getMeterId())
                .orElseThrow(() -> new RuntimeException("Meter not found"));

        boolean hasAccess = reader.getAssignedAreas().stream()
                .anyMatch(area -> area.getId().equals(meter.getArea().getId()));

        if (!hasAccess) {
            throw new OperationNotPermittedException("You are not assigned to this meter's area");
        }



        // Calculate consumption
        Double consumption = request.getReadingValue();

        // Calculate price
        PricingInfo pricingInfo = pricingService.calculatePrice(consumption);


        ReadingStatus status = ReadingStatus.APPROVED;

//        if (validationMessage != null) {
//            status = ReadingStatus.FLAGGED;
//            notificationService.sendReadingVarianceAlert(
//                    meter.getId(),
//                    request.getReadingValue(),
//                    previousReading.map(MeterReading::getReadingValue).orElse(0.0),
//                    reader.getId()
//            );
//        }

        // Create and save reading
        MeterReading reading = MeterReading.builder()
                .meter(meter)
                .reader(reader)
                .readingValue(request.getReadingValue())
                .readingDate(LocalDateTime.now())
                .meterImage(request.getMeterImage())
                .notes(request.getNotes())
                .status(status)
                .consumption(consumption)
                .unitPrice(pricingInfo.getUnitPrice())
                .totalPrice(pricingInfo.getTotalPrice())
                .createdDate(LocalDateTime.now())
                .build();

        MeterReading savedReading = meterReadingRepository.save(reading);

        // Update meter with latest reading
        meter.setLastReadingValue(request.getReadingValue());
        meter.setLastReadingDate(LocalDateTime.now());
        meterRepository.save(meter);

        MeterReadingResponse response = meterReadingMapper.toResponse(savedReading);

        return ResultResponse.<MeterReadingResponse>builder()
                .status("success")
                .data(response)
                .build();
    }

    private Double calculateConsumption(Double currentReading, Optional<MeterReading> previousReading) {
        if (previousReading.isEmpty()) {
            return currentReading;
        }
        return currentReading - previousReading.get().getReadingValue();
    }



    @Transactional
    public PageResponse<MeterReadingResponse> getReadingHistoryForReader(
            UUID meterId, UUID userId, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("readingDate").descending());
        Page<MeterReading> readings = meterReadingRepository.findByMeterAndReader(
                meterId, userId, pageable);

        List<MeterReadingResponse> content = readings.getContent().stream()
                .map(meterReadingMapper::toResponse)
                .collect(Collectors.toList());

        return new PageResponse<>(
                content,
                readings.getNumber(),
                readings.getSize(),
                readings.getTotalElements(),
                readings.getTotalPages(),
                readings.isFirst(),
                readings.isLast()
        );
    }


    @Transactional
    public PageResponse<MeterReadingResponse> getReadingHistory(
            UUID meterId, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("readingDate").descending());
        Page<MeterReading> readings = meterReadingRepository.findByMeter(
                meterId, pageable);

        List<MeterReadingResponse> content = readings.getContent().stream()
                .map(meterReadingMapper::toResponse)
                .collect(Collectors.toList());

        return new PageResponse<>(
                content,
                readings.getNumber(),
                readings.getSize(),
                readings.getTotalElements(),
                readings.getTotalPages(),
                readings.isFirst(),
                readings.isLast()
        );
    }



    public PageResponse<MeterReadingResponse> getAssignedReadingsForReader(
            UUID userId, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("readingDate").descending());
        Page<MeterReading> readings = meterReadingRepository.findByReader(
                userId, pageable);

        List<MeterReadingResponse> content = readings.getContent().stream()
                .map(meterReadingMapper::toResponse)
                .collect(Collectors.toList());

        return new PageResponse<>(
                content,
                readings.getNumber(),
                readings.getSize(),
                readings.getTotalElements(),
                readings.getTotalPages(),
                readings.isFirst(),
                readings.isLast()
        );
    }

    public PageResponse<MeterReadingResponse> getAllMeterReadings(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("readingDate").descending());
        Page<MeterReading> readings = meterReadingRepository.findAll(pageable);

        List<MeterReadingResponse> content = readings.getContent().stream()
                .map(meterReadingMapper::toResponse)
                .collect(Collectors.toList());

        return new PageResponse<>(
                content,
                readings.getNumber(),
                readings.getSize(),
                readings.getTotalElements(),
                readings.getTotalPages(),
                readings.isFirst(),
                readings.isLast()
        );
    }

    // Get all meter readings for a specific meter (paginated)
    public PageResponse<MeterReadingResponse> getMeterReadingsByMeterId(UUID meterId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("readingDate").descending());
        Page<MeterReading> readings = meterReadingRepository.findByMeterId(meterId, pageable);

        List<MeterReadingResponse> content = readings.getContent().stream()
                .map(meterReadingMapper::toResponse)
                .collect(Collectors.toList());

        return new PageResponse<>(
                content,
                readings.getNumber(),
                readings.getSize(),
                readings.getTotalElements(),
                readings.getTotalPages(),
                readings.isFirst(),
                readings.isLast()
        );
    }

    // Delete a meter reading
    @Transactional
    public ResultResponse<String> deleteMeterReading(UUID readingId) {
        MeterReading reading = meterReadingRepository.findById(readingId)
                .orElseThrow(() -> new RuntimeException("Meter reading not found"));

        // Check if this is the latest reading for the meter
        Optional<MeterReading> latestReading = meterReadingRepository
                .findTopByMeterIdOrderByReadingDateDesc(reading.getMeter().getId());

        if (latestReading.isPresent() && latestReading.get().getId().equals(readingId)) {
            // Update meter's last reading if we're deleting the latest one
            Meter meter = reading.getMeter();
            Optional<MeterReading> newLatest = meterReadingRepository
                    .findTopByMeterIdAndIdNotOrderByReadingDateDesc(meter.getId(), readingId);

            if (newLatest.isPresent()) {
                meter.setLastReadingValue(newLatest.get().getReadingValue());
                meter.setLastReadingDate(newLatest.get().getReadingDate());
            } else {
                meter.setLastReadingValue(null);
                meter.setLastReadingDate(null);
            }
            meterRepository.save(meter);
        }

        meterReadingRepository.deleteById(readingId);

        return ResultResponse.<String>builder()
                .status("success")
                .data("Meter reading deleted successfully")
                .build();
    }
}
