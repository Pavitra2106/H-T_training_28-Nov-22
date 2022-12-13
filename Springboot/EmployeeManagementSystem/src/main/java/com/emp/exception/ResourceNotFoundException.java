package com.emp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialversionUID =1L;
	private String resourecName;
	private String fieldName;
	private Object fieldvalue;
	public String getResourecName() {
		return resourecName;
	}
	
	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldvalue() {
		return fieldvalue;
	}

	public ResourceNotFoundException(String resourecName, String fieldName,Object fieldvalue ) {
		super(String.format("%s not found with %s : %s",resourecName,fieldName,fieldvalue));
		this.resourecName = resourecName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}
	
}
