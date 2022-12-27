package com.digitalbooks.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.digitalbooks.response.MessageResponse;

@RestControllerAdvice
public class ControllerExceptionHandler {


	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidRequestException.class)
	public MessageResponse handleBadRequest(InvalidRequestException ex) {
		return new MessageResponse(ex.getMessage());
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RequestNotFounException.class)
	public MessageResponse handleNotFound(RequestNotFounException rnf) {
		return new MessageResponse(rnf.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public MessageResponse handleGeneralError(MethodArgumentNotValidException ex) {


		List<FieldError> errors = ex.getFieldErrors();
		Map<String, String> errorMap = new HashMap<>();
		errors.forEach(error -> {
			String field = error.getField();
			String msg = error.getDefaultMessage();
			errorMap.put(field, msg);

		});

		return new MessageResponse(ex.getMessage());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public MessageResponse handleGeneralError(Exception ex) {

		return new MessageResponse("Error : An error occurred procesing request " + ex.getMessage());
	}
}
