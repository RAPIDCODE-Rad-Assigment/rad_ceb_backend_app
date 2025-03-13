package com.rapidcode.api.common;

public class ResultResponse<T> {
    private String status;
    private T data;

    // Constructor
    public ResultResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    // Getters
    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    // Setters
    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }

    // Builder
    public static <T> ResultResponseBuilder<T> builder() {
        return new ResultResponseBuilder<>();
    }

    public static class ResultResponseBuilder<T> {
        private String status;
        private T data;

        public ResultResponseBuilder<T> status(String status) {
            this.status = status;
            return this;
        }

        public ResultResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResultResponse<T> build() {
            return new ResultResponse<>(status, data);
        }
    }
}