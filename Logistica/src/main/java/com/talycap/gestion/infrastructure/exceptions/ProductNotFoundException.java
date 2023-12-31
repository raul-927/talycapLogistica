package com.talycap.gestion.infrastructure.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException() {}
	public ProductNotFoundException(String message) {
		super(message);
	}
	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	

}
