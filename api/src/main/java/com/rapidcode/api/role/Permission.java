package com.rapidcode.api.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),

    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_CREATE("user:create"),
    USER_DELETE("user:delete"),

    METER_READER_READ("meter_reader:read"),
    METER_READER_UPDATE("meter_reader:update"),
    METER_READER_CREATE("meter_reader:create"),
    METER_READER_DELETE("meter_reader:delete"),

    METER_READ("meter:read"),
    METER_UPDATE("meter:update"),
    METER_CREATE("meter:create"),
    METER_DELETE("meter:delete"),

    BILL_READ("bill:read"),
    BILL_UPDATE("bill:update"),
    BILL_CREATE("bill:create"),
    BILL_DELETE("bill:delete");

    private final String permission;

    // Constructor
    private Permission(String permission) {
        this.permission = permission;
    }

    // Getter (if Lombok is not working)
    public String getPermission() {
        return this.permission;
    }
}