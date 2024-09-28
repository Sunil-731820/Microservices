package com.example.HotelService.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
		super("Resource not found for this hotel id ");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	

}
