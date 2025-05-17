package com.rapidcode.api.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notifications/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class NotificationAdminController {


    private final NotificationService notificationService;

    // POST /api/notifications
    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Map<String, String> payload) {
        LocalDate date = LocalDate.parse(payload.get("date"));
        LocalTime time = LocalTime.parse(payload.get("time"));
        String location = payload.get("location");
        String reason = payload.get("reason");

        Notification notification = notificationService.createNotification(date, time, location, reason);
        return ResponseEntity.ok(notification);
    }

    // GET /api/notifications
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    // Optional: GET /api/notifications/unread
    @GetMapping("/unread")
    public ResponseEntity<List<Notification>> getUnreadNotifications() {
        return ResponseEntity.ok(notificationService.getUnreadNotifications());
    }
}
