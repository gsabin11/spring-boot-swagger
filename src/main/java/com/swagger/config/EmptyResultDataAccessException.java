package com.swagger.config;

public class EmptyResultDataAccessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EmptyResultDataAccessException(String message, int affectedRows) {
		super(message, null, false, false);
		this.affectedRows = affectedRows;
	}
	
	private int affectedRows;
	
	public int getAffectedRows() {
		return affectedRows;
	}
}
