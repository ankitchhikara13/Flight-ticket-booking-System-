package com.manipal.exception;

public class FlightsNotFoundException extends RuntimeException{
	String message;

	public FlightsNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
}
