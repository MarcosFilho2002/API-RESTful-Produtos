package com.example.primeiroexemplo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.MethodNotAllowed;

import com.example.primeiroexemplo.model.error.ErrorMessage;
import com.example.primeiroexemplo.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex){
        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodNotAllowed.class)
    public ResponseEntity<?> handleResourceMethodNotAllowed(MethodNotAllowed ex){
        ErrorMessage error = new ErrorMessage("Method Not Allowed", HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
