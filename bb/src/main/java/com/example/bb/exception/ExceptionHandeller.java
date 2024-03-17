package com.example.bb.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import io.jsonwebtoken.ExpiredJwtException;

@RestControllerAdvice
public class ExceptionHandeller {


	@ExceptionHandler(value = ResponseStatusException.class)
	public ResponseEntity<Map<String, String>> responseStatusException(ResponseStatusException be) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("message", be.getMessage());
		return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<Map<String, String>> businessException(BusinessException be) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("message", be.getMessage());
		return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException me) {
		Map<String, String> errorMap = new HashMap<>();
		me.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});

		return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Map<String, String>> exception(Exception e) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("message", e.getMessage());
		return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = ExpiredJwtException.class)
	public ResponseEntity<Map<String, String>> expiredJwtException(ExpiredJwtException e) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("message", "JWT expired");
		return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.UNAUTHORIZED);
	}
}