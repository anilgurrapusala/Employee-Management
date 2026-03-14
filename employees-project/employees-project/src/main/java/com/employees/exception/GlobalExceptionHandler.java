package com.employees.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {
	
	//404 not found
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	//400 Bad request
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalException(IllegalArgumentException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	//500 Internal Server Error 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGlobalException(Exception ex){
		return new ResponseEntity<>("Something Went Wrong Mawa : "+ex.getMessage()
		,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}