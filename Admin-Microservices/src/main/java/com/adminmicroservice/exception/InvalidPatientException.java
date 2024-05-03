package com.adminmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidPatientException extends Exception {
	public InvalidPatientException(String msg) {
		super(msg);
	}

}
