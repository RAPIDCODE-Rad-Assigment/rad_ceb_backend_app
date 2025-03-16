package com.rapidcode.api.email;

import lombok.Getter;

@Getter
public enum EmailTemplateName {

    ACTIVATE_ACCOUNT("activate_account"),
    FORGOT_PASSWORD("forgot_password"),
    DELETE_ACCOUNT("account_deletion_email"),
    DEACTIVATE_ACCOUNT("account_deactivate_email"),
    ACCOUNT_CREATED("account_created_email.html");


    private final String name;

    EmailTemplateName(String name) {
        this.name = name;
    }
}