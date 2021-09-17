package com.feeapp.feenotifier.spi.enums;

public enum UserLoginResponse {
    SUCCESS,
    INVALID_EMAIL_OR_PASSWORD,
    INCORRECT_PASSWORD,
    ACCOUNT_BLOCKED,
    ACCOUNT_EXPIRED,
    UNKNOWN_ERROR;
}
