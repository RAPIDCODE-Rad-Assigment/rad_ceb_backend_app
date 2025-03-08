package com.rapidcode.api.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionResponse {

    private Integer businessErrorCode;
    private String businessErrorDescription;
    private String error;
    private Set<String> validationErrors;
    private Map<String, String> errors;

    // Default constructor
    public ExceptionResponse() {
    }

    // All-args constructor
    public ExceptionResponse(Integer businessErrorCode, String businessErrorDescription, String error,
                             Set<String> validationErrors, Map<String, String> errors) {
        this.businessErrorCode = businessErrorCode;
        this.businessErrorDescription = businessErrorDescription;
        this.error = error;
        this.validationErrors = validationErrors;
        this.errors = errors;
    }

    // Getters
    public Integer getBusinessErrorCode() {
        return businessErrorCode;
    }

    public String getBusinessErrorDescription() {
        return businessErrorDescription;
    }

    public String getError() {
        return error;
    }

    public Set<String> getValidationErrors() {
        return validationErrors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    // Setters
    public void setBusinessErrorCode(Integer businessErrorCode) {
        this.businessErrorCode = businessErrorCode;
    }

    public void setBusinessErrorDescription(String businessErrorDescription) {
        this.businessErrorDescription = businessErrorDescription;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setValidationErrors(Set<String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    // Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer businessErrorCode;
        private String businessErrorDescription;
        private String error;
        private Set<String> validationErrors;
        private Map<String, String> errors;

        public Builder businessErrorCode(Integer businessErrorCode) {
            this.businessErrorCode = businessErrorCode;
            return this;
        }

        public Builder businessErrorDescription(String businessErrorDescription) {
            this.businessErrorDescription = businessErrorDescription;
            return this;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        public Builder validationErrors(Set<String> validationErrors) {
            this.validationErrors = validationErrors;
            return this;
        }

        public Builder errors(Map<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public ExceptionResponse build() {
            return new ExceptionResponse(businessErrorCode, businessErrorDescription, error, validationErrors, errors);
        }
    }
}