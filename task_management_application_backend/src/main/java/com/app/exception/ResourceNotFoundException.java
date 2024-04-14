package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	// Constructor to initialize ResourceNotFoundException with a custom message
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
