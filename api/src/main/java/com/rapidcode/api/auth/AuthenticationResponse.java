package com.rapidcode.api.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    // Default constructor
    public AuthenticationResponse() {
    }

    // All-args constructor
    public AuthenticationResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    // Getters and Setters
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    // Builder pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String accessToken;
        private String refreshToken;

        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(accessToken, refreshToken);
        }
    }
}