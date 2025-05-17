package com.rapidcode.api.notification;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Transactional
    public Notification createNotification(LocalDate date, LocalTime time, String location, String reason) {
        Notification notification = new Notification();
        notification.setDate(date);
        notification.setTime(time);
        notification.setLocation(location);
        notification.setReason(reason);
        notification.setRead(false);
        notification.setCreatedAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    @Transactional
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Transactional
    public List<Notification> getUnreadNotifications() {
        return notificationRepository.findByReadFalse();
    }
}
