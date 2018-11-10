package br.com.devmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException {
	private String personName;
	private String fieldName;
	private Object fieldValue;

	public ModelNotFoundException(String personName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", personName, fieldName, fieldValue));
		this.personName = personName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getName() {
		return personName;
	}

	public String getPrice() {
		return fieldName;
	}	
}
