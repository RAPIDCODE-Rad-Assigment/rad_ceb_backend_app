package com.rapidcode.api.meter;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface MeterRepository extends JpaRepository<Meter, UUID>, JpaSpecificationExecutor<Meter> {

    Optional<Meter> findByMeterNumber(String meterNumber);

    @Query("SELECT m FROM Meter m JOIN FETCH m.user WHERE m.id = :meterId")
    Optional<Meter> findByIdWithUser(@Param("meterId") UUID meterId);

    boolean existsByMeterNumber(String meterNumber);

    // Add this method for pagination and filtering
    @NotNull Page<Meter> findAll(Specification<Meter> specification, @NotNull Pageable pageable);
}