package com.example.microservices.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidFormatException.class)
    protected ResponseEntity<CustomErrorResponse> handleInvalidFormatException(Exception ex, WebRequest request) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setErrorCode("999L");
        customErrorResponse.setErrorMessage(ex.getLocalizedMessage());
        customErrorResponse.setStatus(HttpStatus.BAD_REQUEST);
        customErrorResponse.setTime(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customErrorResponse);
    }

    @ExceptionHandler(NumberFormatException.class)
    protected ResponseEntity<CustomErrorResponse> handleNumberFormatException(Exception ex, WebRequest request) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setErrorCode("105L");
        customErrorResponse.setErrorMessage(ex.getLocalizedMessage());
        customErrorResponse.setStatus(HttpStatus.NOT_FOUND);
        customErrorResponse.setTime(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customErrorResponse);
    }

    /*@ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<CustomErrorResponse> handleRunTimeException(Exception ex, WebRequest request) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setErrorCode("105L");
        customErrorResponse.setErrorMessage(ex.getLocalizedMessage());
        customErrorResponse.setStatus(HttpStatus.NOT_FOUND);
        customErrorResponse.setTime(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customErrorResponse);
    }*/
}
