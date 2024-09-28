package com.java.spr.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
		super("Resource not found On the Server ");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

	
}
