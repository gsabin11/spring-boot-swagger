package com.swagger.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.swagger.config.EmptyResultDataAccessException;
import com.swagger.dto.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handleArgumentException(MethodArgumentNotValidException ex){
		Map<String,String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(
				error->errors.put(error.getField(), error.getDefaultMessage()));
			return errors;
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorMessage> handleExceptionFoundEntity (NoSuchElementException ex){
		ErrorMessage errors = new ErrorMessage(new Date(),
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),
				ex.getMessage()
				);
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErrorMessage> handleExceptionFound (EmptyResultDataAccessException ex){
		ErrorMessage errors = new ErrorMessage(new Date(),
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),
				ex.getMessage()
				);
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}
}
