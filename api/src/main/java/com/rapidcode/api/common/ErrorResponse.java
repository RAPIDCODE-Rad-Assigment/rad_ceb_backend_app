package com.rapidcode.api.common;

public class ErrorResponse {
    private String status;
    private String message;

    public ErrorResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ErrorResponseBuilder builder() {
        return new ErrorResponseBuilder();
    }

    public static class ErrorResponseBuilder {
        private String status;
        private String message;

        public ErrorResponseBuilder status(String status) {
            this.status = status;
            return this;
        }

        public ErrorResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(status, message);
        }
    }
}