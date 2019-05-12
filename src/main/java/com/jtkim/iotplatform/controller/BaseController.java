package com.jtkim.iotplatform.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jtkim.iotplatform.exception.IoTPlatformErrorCode;
import com.jtkim.iotplatform.exception.IoTPlatformErrorResponseHandler;
import com.jtkim.iotplatform.exception.IoTPlatformException;

/**
 * 
 * Exception Handlling 등 공통 처리를 위한 BaseController
 * @author JTKIM
 *
 */
public class BaseController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private IoTPlatformErrorResponseHandler errorResponseHandler;

    @ExceptionHandler(IoTPlatformException.class)
    public void handleException(IoTPlatformException ex, HttpServletResponse response) {
        errorResponseHandler.handle(ex);
    }

    IoTPlatformException handleException(Exception exception) {
        return handleException(exception, true);
    }

    private IoTPlatformException handleException(Exception exception, boolean logException) {
        if (logException) {
            log.error(exception.getLocalizedMessage());
        }

        if (exception instanceof IoTPlatformException) {
            return (IoTPlatformException) exception;
        } else if (exception instanceof IllegalArgumentException) {
            return new IoTPlatformException(exception.getMessage(),
                    IoTPlatformErrorCode.INVALID_ARGUMENTS);
        } else {
            return new IoTPlatformException(exception.getMessage(),
                    IoTPlatformErrorCode.GENERAL);
        }
    }
}
