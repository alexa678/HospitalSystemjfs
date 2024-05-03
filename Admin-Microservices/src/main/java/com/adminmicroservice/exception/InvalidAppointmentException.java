package com.adminmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidAppointmentException extends Exception{
	public InvalidAppointmentException(String msg) {
		super(msg);
	}
}

