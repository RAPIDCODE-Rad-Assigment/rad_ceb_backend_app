package com.rapidcode.api.meter_reading;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReading, UUID> {

    // For getReadingHistory
    @Query("SELECT mr FROM MeterReading mr WHERE mr.meter.id = :meterId AND mr.reader.id = :readerId")
    Page<MeterReading> findByMeterAndReader(
            @Param("meterId") UUID meterId,
            @Param("readerId") UUID readerId,
            Pageable pageable
    );

    @Query("SELECT mr FROM MeterReading mr WHERE mr.meter.id = :meterId")
    Page<MeterReading> findByMeter(
            @Param("meterId") UUID meterId,
            Pageable pageable
    );

    // For getAssignedReadings
    @Query("SELECT mr FROM MeterReading mr WHERE mr.reader.id = :readerId")
    Page<MeterReading> findByReader(
            @Param("readerId") UUID readerId,
            Pageable pageable
    );

    // Keep your existing methods
    Optional<MeterReading> findTopByMeterIdOrderByReadingDateDesc(UUID meterId);


    @Query("SELECT mr FROM MeterReading mr WHERE mr.meter.id = :meterId")
    Page<MeterReading> findByMeterId(@Param("meterId") UUID meterId, Pageable pageable);

    @Query("SELECT mr FROM MeterReading mr WHERE mr.meter.id = :meterId AND mr.id != :excludeReadingId ORDER BY mr.readingDate DESC")
    Optional<MeterReading> findTopByMeterIdAndIdNotOrderByReadingDateDesc(
            @Param("meterId") UUID meterId,
            @Param("excludeReadingId") UUID excludeReadingId);
}