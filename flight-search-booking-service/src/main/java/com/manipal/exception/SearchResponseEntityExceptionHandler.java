package com.manipal.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.manipal.exception.ExceptionResponse;
import com.manipal.exception.FlightsNotFoundException;

@ControllerAdvice
public class SearchResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> anything(FlightsNotFoundException exception) {
		ExceptionResponse response=new ExceptionResponse(exception.getMessage(),LocalDateTime.now());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
}
