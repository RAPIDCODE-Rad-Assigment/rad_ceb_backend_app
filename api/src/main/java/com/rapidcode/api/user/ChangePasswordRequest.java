package com.rapidcode.api.user;

public class ChangePasswordRequest {
    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;

    // Constructor
    public ChangePasswordRequest(String currentPassword, String newPassword, String confirmationPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmationPassword = confirmationPassword;
    }

    // No-args Constructor
    public ChangePasswordRequest() {}

    // Getters
    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    // Setters
    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
    }

    // Builder
    public static ChangePasswordRequestBuilder builder() {
        return new ChangePasswordRequestBuilder();
    }

    public static class ChangePasswordRequestBuilder {
        private String currentPassword;
        private String newPassword;
        private String confirmationPassword;

        public ChangePasswordRequestBuilder currentPassword(String currentPassword) {
            this.currentPassword = currentPassword;
            return this;
        }

        public ChangePasswordRequestBuilder newPassword(String newPassword) {
            this.newPassword = newPassword;
            return this;
        }

        public ChangePasswordRequestBuilder confirmationPassword(String confirmationPassword) {
            this.confirmationPassword = confirmationPassword;
            return this;
        }

        public ChangePasswordRequest build() {
            return new ChangePasswordRequest(currentPassword, newPassword, confirmationPassword);
        }
    }
}