package com.rapidcode.api.payment;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventResponse {
    private String date;
    private String title;
    private String description;
    private String icon;
    private LocalDateTime createdAt;
}