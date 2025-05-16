package com.rapidcode.api.meter;
import com.rapidcode.api.area.Area;
import com.rapidcode.api.area.AreaRepository;
import com.rapidcode.api.common.PageResponse;
import com.rapidcode.api.common.ResultResponse;
import com.rapidcode.api.handler.OperationNotPermittedException;
import com.rapidcode.api.role.RoleName;
import com.rapidcode.api.user.User;
import com.rapidcode.api.user.UserMapper;
import com.rapidcode.api.user.UserRepository;
import com.rapidcode.api.user.UserResponse;
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
    private final UserMapper userMapper;
    private final AreaRepository areaRepository; // Add AreaRepository

    @Transactional
    public ResultResponse<MeterResponse> createOrUpdateMeter(MeterRequest meterRequest, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Meter meter = meterRepository.findByMeterNumber(meterRequest.meterNumber())
                .orElse(new Meter());

        Area area = areaRepository.findById(meterRequest.areaId())
                .orElseThrow(() -> new RuntimeException("Area not found with ID: " + meterRequest.areaId()));

        meter.setMeterNumber(meterRequest.meterNumber());
        meter.setInstallationDate(meterRequest.installationDate());
        meter.setStatus(meterRequest.status());
        meter.setUser(user);
        meter.setArea(area);
        meter.setCreatedDate(LocalDateTime.now());
        meter.setLastModifiedDate(LocalDateTime.now());
        meter.setDueAmount(0.0);

        Meter savedMeter = meterRepository.save(meter);

        System.out.println(savedMeter.getId());
        return meterRepository.findByIdWithUser(savedMeter.getId())
                .map(MeterMapper::toMeterResponse)
                .map(response -> ResultResponse.<MeterResponse>builder()
                        .status("success")
                        .data(response)
                        .build())
                .orElseThrow(() -> new RuntimeException("Failed to fetch meter details"));
    }

    @Transactional
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
            String userName
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


    @Transactional
    public PageResponse<UserResponse> getAllUsersExcludingAdminAndMeterReader(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());

        // Define roles to exclude
        List<String> rolesToExclude = List.of(RoleName.ADMIN.name(), RoleName.METER_READER.name());

        // Fetch users excluding ADMIN and METER_READER roles
        Page<User> users = userRepository.findAllExcludingRoles(rolesToExclude, pageable);

        // Map to UserResponse
        List<UserResponse> usersAsResponse = users.stream()
                .map(userMapper::toUserResponse)
                .toList();

        return new PageResponse<>(
                usersAsResponse,
                users.getNumber(),
                users.getSize(),
                users.getTotalElements(),
                users.getTotalPages(),
                users.isFirst(),
                users.isLast()
        );
    }

    @Transactional
    public ResultResponse<List<MeterResponse>> getAllMetersForMeterReader(
            int page,
            int size,
            String sortBy,
            String sortDir,
            MeterStatus status,
            String userName,
            User autUser  // Accept user ID instead of User object
    ) {

        // Fetch user with areas eagerly
        User authenticatedUser = userRepository.findByIdWithAssignedAreas(autUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Meter> specification = Specification.where(null);

        boolean isMeterReader = authenticatedUser.getRoles().stream()
                .anyMatch(role -> role.getName().equals(RoleName.METER_READER.name()));

        if (isMeterReader) {
            List<UUID> areaIds = authenticatedUser.getAssignedAreas().stream()
                    .map(Area::getId)
                    .collect(Collectors.toList());

            specification = specification.and(MeterSpecification.hasAreaIdIn(areaIds));
        } else {
            throw new OperationNotPermittedException("Operation not permitted");
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
}
