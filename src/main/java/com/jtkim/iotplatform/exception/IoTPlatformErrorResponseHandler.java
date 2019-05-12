package com.jtkim.iotplatform.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class IoTPlatformErrorResponseHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<Object> handle(IoTPlatformException ex) {

        IoTPlatformErrorCode errorCode = ex.getErrorCode();
        HttpStatus status;

        switch (errorCode) {
        case AUTHENTICATION:
            status = HttpStatus.UNAUTHORIZED;
            break;
        case PERMISSION_DENIED:
            status = HttpStatus.FORBIDDEN;
            break;
        case INVALID_ARGUMENTS:
            status = HttpStatus.BAD_REQUEST;
            break;
        case RESOURCE_NOT_FOUND:
            status = HttpStatus.NOT_FOUND;
            break;
        case BAD_REQUEST_PARAM:
            status = HttpStatus.BAD_REQUEST;
            break;
        case GENERAL:
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            break;
        default:
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            break;
        }

        IoTPlatformError apiError = new IoTPlatformError(status);
        apiError.setMessage(ex.getMessage());

        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(IoTPlatformError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
