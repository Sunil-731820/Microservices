package com.java.spr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        System.out.println("The Value of The Message is :"+message);
        return new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);

    }

}
