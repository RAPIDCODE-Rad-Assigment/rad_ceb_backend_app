package com.rapidcode.api.handler;

public class OnlyOneAdminAllowedException extends RuntimeException {

    public OnlyOneAdminAllowedException(String message) {
        super(message);
    }
}
