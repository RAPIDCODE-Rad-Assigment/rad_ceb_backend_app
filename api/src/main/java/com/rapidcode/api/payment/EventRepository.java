package com.rapidcode.api.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {


    @Query("SELECT e FROM Event e JOIN FETCH e.meter WHERE e.meter.id = :meterId ORDER BY e.createdAt DESC")
    List<Event> findByMeterIdOrderByCreatedAtDesc(@Param("meterId") UUID meterId);

    /**
     * Find all events for a specific meter and event type (icon)
     * @param meterId The ID of the meter
     * @param icon The event type/icon (e.g., "payment", "bill")
     * @return List of matching events
     */
    List<Event> findByMeterIdAndIconOrderByCreatedAtDesc(UUID meterId, String icon);

    /**
     * Count all events for a specific meter
     * @param meterId The ID of the meter
     * @return Number of events
     */
    long countByMeterId(UUID meterId);
}