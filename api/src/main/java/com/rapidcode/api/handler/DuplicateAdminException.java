package com.rapidcode.api.handler;

public class DuplicateAdminException extends RuntimeException {
    public DuplicateAdminException(String m) {
        super(m);
    }
}
