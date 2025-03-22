package com.rapidcode.api.meter;
import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.user.User;
import com.rapidcode.api.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeterService {

    private final MeterRepository meterRepository;
    private final UserRepository userRepository;

    @Transactional
    public ResultResponse<MeterResponse> createOrUpdateMeter(MeterRequest meterRequest, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Meter meter = meterRepository.findByMeterNumber(meterRequest.meterNumber())
                .orElse(new Meter());

        meter.setMeterNumber(meterRequest.meterNumber());
        meter.setInstallationDate(meterRequest.installationDate());
        meter.setStatus(meterRequest.status());
        meter.setUser(user);
        meter.setCreatedDate(LocalDateTime.now());
        meter.setLastModifiedDate(LocalDateTime.now());

        Meter savedMeter = meterRepository.save(meter);

        return meterRepository.findByIdWithUser(savedMeter.getId())
                .map(MeterMapper::toMeterResponse)
                .map(response -> ResultResponse.<MeterResponse>builder()
                        .status("success")
                        .data(response)
                        .build())
                .orElseThrow(() -> new RuntimeException("Failed to fetch meter details"));
    }

    public ResultResponse<MeterResponse> getMeterById(UUID meterId) {
        Meter meter = meterRepository.findById(meterId)
                .orElseThrow(() -> new RuntimeException("Meter not found with ID: " + meterId));

        MeterResponse response = MeterMapper.toMeterResponse(meter);

        return ResultResponse.<MeterResponse>builder()
                .status("success")
                .data(response)
                .build();
    }


    @Transactional
    public ResultResponse<List<MeterResponse>> getAllMeters(
            int page,
            int size,
            String sortBy,
            String sortDir,
            MeterStatus status,
            String userName // Add this parameter
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Meter> specification = Specification.where(null);

        if (status != null) {
            specification = specification.and(MeterSpecification.hasStatus(status));
        }

        if (userName != null && !userName.isEmpty()) {
            specification = specification.and(MeterSpecification.hasUserName(userName));
        }

        Page<Meter> meterPage = meterRepository.findAll(specification, pageable);

        List<MeterResponse> meterResponses = meterPage.getContent().stream()
                .map(MeterMapper::toMeterResponse)
                .collect(Collectors.toList());

        return ResultResponse.<List<MeterResponse>>builder()
                .status("success")
                .data(meterResponses)
                .build();
    }

    @Transactional
    public ResultResponse<String> deleteMeter(UUID meterId) {
        if (!meterRepository.existsById(meterId)) {
            throw new RuntimeException("Meter not found with ID: " + meterId);
        }

        meterRepository.deleteById(meterId);

        return ResultResponse.<String>builder()
                .status("success")
                .data("Meter deleted successfully")
                .build();
    }
}
