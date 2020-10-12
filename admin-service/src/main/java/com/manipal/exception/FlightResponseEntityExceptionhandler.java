package com.manipal.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

	@ControllerAdvice
	public class FlightResponseEntityExceptionhandler extends ResponseEntityExceptionHandler {
		@ExceptionHandler(FlightdetailsNotFoundException.class)
		public ResponseEntity<ExceptionResponse> movieNotFound(FlightdetailsNotFoundException exception) {
			ExceptionResponse response = new ExceptionResponse(exception.getMessage(),LocalDateTime.now());
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}
