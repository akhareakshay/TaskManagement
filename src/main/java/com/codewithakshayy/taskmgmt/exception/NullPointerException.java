package com.codewithakshayy.taskmgmt.exception;

import lombok.Data;

@Data
public class NullPointerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public NullPointerException() {
	}

	public NullPointerException(String message) {
		super();
		this.message = message;
	}

}
