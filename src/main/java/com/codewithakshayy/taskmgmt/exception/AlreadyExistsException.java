package com.codewithakshayy.taskmgmt.exception;

public class AlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public AlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	public AlreadyExistsException() {
	}

}
