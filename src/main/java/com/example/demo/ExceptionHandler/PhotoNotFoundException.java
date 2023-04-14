package com.example.demo.ExceptionHandler;


public class PhotoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PhotoNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PhotoNotFoundException(String message) {
		super(message);
	}

	
}
