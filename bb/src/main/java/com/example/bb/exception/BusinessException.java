package com.example.bb.exception;

public class BusinessException extends RuntimeException { 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String errorMessage) {
        super(errorMessage);
    }
}