package com.jtkim.iotplatform.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class IoTPlatformError {

	private HttpStatus status;
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;

	private IoTPlatformError() {
		timestamp = LocalDateTime.now();
	}

	IoTPlatformError(HttpStatus status) {
		this();
		this.status = status;
	}

	IoTPlatformError(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	IoTPlatformError(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	
}
