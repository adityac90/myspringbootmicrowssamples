/**
 * 
 */
package com.example.demo.services.error.handlers;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.services.error.ApiErrorResponse;
import com.example.demo.services.error.manufacturer.ManufactuerNotFoundException;
import com.example.demo.services.error.manufacturer.ManufacturerNotSavedException;

/**
 * @author aditya chakraborty
 *
 */
@RestControllerAdvice
public class ApiExceptionHandler {
	@Autowired
	private ApiErrorResponse apiErrorResponse;

	@ExceptionHandler(ManufactuerNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> handlerManufactuerNotFoundException(Exception ex) {
		apiErrorResponse.setErrorCode("9100");
		apiErrorResponse.setErrorMsg(ex.getLocalizedMessage());
		apiErrorResponse.setTimeStamp(ZonedDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrorResponse);
	}

	@ExceptionHandler(ManufacturerNotSavedException.class)
	public ResponseEntity<ApiErrorResponse> handlerManufactuerNotSavedException(Exception ex) {
		apiErrorResponse.setErrorCode("9101");
		apiErrorResponse.setErrorMsg(ex.getLocalizedMessage());
		apiErrorResponse.setTimeStamp(ZonedDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
	}

}
