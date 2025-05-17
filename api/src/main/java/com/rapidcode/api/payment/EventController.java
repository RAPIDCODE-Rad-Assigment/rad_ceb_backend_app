package com.rapidcode.api.payment;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
@PreAuthorize("hasRole('USER')")
public class EventController {

    private final EventRepository eventRepository;

    @GetMapping("/meter/{meterId}")
    @Transactional
    public ResponseEntity<List<EventResponse>> getEventsByMeterId(@PathVariable UUID meterId) {
        List<Event> events = eventRepository.findByMeterIdOrderByCreatedAtDesc(meterId);
        List<EventResponse> response = events.stream()
                .map(EventMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }
}