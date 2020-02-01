package com.haldar.sample.microservice.exception;

public class ResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7114788069422664060L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
