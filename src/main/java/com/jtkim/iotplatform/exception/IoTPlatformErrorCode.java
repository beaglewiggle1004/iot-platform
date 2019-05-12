package com.jtkim.iotplatform.exception;

public enum IoTPlatformErrorCode {

    GENERAL(2),
    AUTHENTICATION(10),
    PERMISSION_DENIED(20),
    INVALID_ARGUMENTS(30),
    BAD_REQUEST_PARAM(31),
    RESOURCE_NOT_FOUND(40);

    private int errorCode;

    IoTPlatformErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}