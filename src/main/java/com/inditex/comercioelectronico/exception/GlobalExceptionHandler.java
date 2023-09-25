package com.inditex.comercioelectronico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PriceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handlePriceNotFoundException(PriceNotFoundException ex) {
		log.warn("PriceNotFoundException occurred: {}", ex.getMessage());
		return ex.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String unhandleExceptions(Exception ex) {
		log.error("An unexpected error occurred: {}", ex.getMessage(), ex);
		return "An unexpected error ocurred. Please try again later";
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleValidationException(MethodArgumentNotValidException ex) {
		StringBuilder sb = new StringBuilder("Validation failed for the following fields: ");
		
		for (FieldError error: ex.getBindingResult().getFieldErrors()) {
			sb.append(error.getField()).append(" ").append(error.getDefaultMessage()).append(", ");
		}
		
		// Remove trailing comma and space
		sb.setLength(sb.length() - 2);
		
		return sb.toString();
	}

}
