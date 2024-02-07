package nology.io.testereclipse.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nology.io.testereclipse.common.exceptions.NotFoundException;
import nology.io.testereclipse.common.exceptions.ServiceValidationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), NotFoundException.getStatusCode());
	}

	@ExceptionHandler(ServiceValidationException.class)
	public ResponseEntity<String> handleServiceValidationException(ServiceValidationException ex) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(ex.getErrors());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>("Oops", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
	}

}
