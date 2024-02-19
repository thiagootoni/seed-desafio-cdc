package com.thiago.desafiocdc.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validationHandler(MethodArgumentNotValidException e, HttpServletRequest request){

        var errorMessage = "Validation Error";
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        var validationError =  ValidationError.from(String.valueOf(status.value()), errorMessage, e.getFieldErrors());

        return ResponseEntity.status(status).body(validationError);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> IllegalArgumentHandler(IllegalArgumentException e, HttpServletRequest request){
        var errorMessage = e.getMessage();
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        return ResponseEntity.status(status).body(new StandardError(String.valueOf(status.value()), errorMessage));
    }
}
