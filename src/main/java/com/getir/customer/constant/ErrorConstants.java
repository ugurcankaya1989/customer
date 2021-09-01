package com.getir.customer.constant;

public enum ErrorConstants {
    EMAIL_NOT_VALID("10","Email format NOT valid!"),
    EMAIL_IS_BEING_USED_BY_ANOTHER_USER("20","E-mail is being used by another user!");

    private String errorCode;
    private String description;

    ErrorConstants(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
