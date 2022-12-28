package com.formation.microservices.web.services.RestFullwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AbsenceDeDonneesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AbsenceDeDonneesException(String message, int id) {
		super(message);
	}
	public AbsenceDeDonneesException(String message) {
		super(message);
	}

	public AbsenceDeDonneesException(Throwable cause) {
		super(cause);	
	}	

}
