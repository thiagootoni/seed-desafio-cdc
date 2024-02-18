package com.thiago.desafiocdc.exceptions;

import org.springframework.validation.FieldError;

import java.util.List;

public record ValidationError(String error, String message, List<FieldMessage> errors) {

    public static ValidationError from(String error, String message, List<FieldError> errors) {
        return new ValidationError(error, message, fillErrors(errors));
    }

    private static List<FieldMessage> fillErrors(List<FieldError> failedValidations) {
        return failedValidations.stream().map(fieldError -> new FieldMessage(fieldError.getField(), fieldError.getDefaultMessage())).toList();
    }

    public record FieldMessage(String field, String message) {
    }
}
