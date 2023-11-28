package com.codewithakshayy.taskmgmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = AlreadyExistsException.class)
	public @ResponseBody ErrorResponse handleAlreadyExistsException(AlreadyExistsException alreadyExistsException) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), alreadyExistsException.getMessage());
	}

	@ExceptionHandler(value = NotFoundException.class)
	public @ResponseBody ErrorResponse handleNotFoundException(NotFoundException notFoundException) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), notFoundException.getMessage());
	}

	@ExceptionHandler(value = NullPointerException.class)
	public @ResponseBody ErrorResponse handleNullPointerException(NullPointerException nullPointerException) {
		return new ErrorResponse(HttpStatus.NO_CONTENT.value(), nullPointerException.getMessage());
	}

}
