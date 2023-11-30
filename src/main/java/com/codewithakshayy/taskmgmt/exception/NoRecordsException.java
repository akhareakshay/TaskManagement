package com.codewithakshayy.taskmgmt.exception;

public class NoRecordsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public NoRecordsException() {
		// TODO Auto-generated constructor stub
	}

	public NoRecordsException(String message) {
		super();
		this.message = message;
	}

}
