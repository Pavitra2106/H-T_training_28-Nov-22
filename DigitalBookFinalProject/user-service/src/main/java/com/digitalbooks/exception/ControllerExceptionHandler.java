package com.digitalbooks.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {


	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidRequestException.class)
	public String handleBadRequest(InvalidRequestException ex) {

		return ex.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RoleNotFoundException.class)
	public String handleNotFound(RoleNotFoundException rnf) {
		return "Error : Requested Role not found!";
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RequestNotFounException.class)
	public String handleNotFound(RequestNotFounException rnf) {
		return rnf.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String handleGeneralError(MethodArgumentNotValidException ex) {


		List<FieldError> errors = ex.getFieldErrors();
		Map<String, String> errorMap = new HashMap<>();
		errors.forEach(error -> {
			String field = error.getField();
			String msg = error.getDefaultMessage();
			errorMap.put(field, msg);

		});

		return ex.getMessage();
	}

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(AccessDeniedException.class)
	public String handleGeneralError(AccessDeniedException ex) {

		return "Error : " + ex.getMessage();
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(BadCredentialsException.class)
	public String handleGeneralError(BadCredentialsException ex) {

		return "Error : " + ex.getMessage();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleGeneralError(Exception ex) {

		return "Error : An error occurred procesing request " + ex.getMessage();
	}
}
