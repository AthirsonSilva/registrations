package com.api.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class EmailAlreadyExistsException extends RuntimeException {
	private String message;

	public EmailAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
}
