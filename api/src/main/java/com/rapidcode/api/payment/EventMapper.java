package com.rapidcode.api.payment;

public class EventMapper {
    public static EventResponse toResponse(Event event) {
        return EventResponse.builder()
                .date(event.getDate())
                .title(event.getTitle())
                .description(event.getDescription())
                .icon(event.getIcon())
                .createdAt(event.getCreatedAt())
                .build();
    }
}