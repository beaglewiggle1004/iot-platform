package com.jtkim.iotplatform.exception;

public class IoTPlatformException extends Exception {

    private static final long serialVersionUID = 1L;

    private IoTPlatformErrorCode errorCode;

    public IoTPlatformException() {
        super();
    }

    public IoTPlatformException(IoTPlatformErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public IoTPlatformException(String message, IoTPlatformErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public IoTPlatformException(String message, Throwable cause, IoTPlatformErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public IoTPlatformException(Throwable cause, IoTPlatformErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public IoTPlatformErrorCode getErrorCode() {
        return errorCode;
    }

}
