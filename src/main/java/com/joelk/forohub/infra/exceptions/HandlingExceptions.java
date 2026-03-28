package com.joelk.forohub.infra.exceptions;

import com.joelk.forohub.domain.ValidationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlingExceptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404NotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity erro400Client(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DataValidationError::new).toList());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handle400Jackson(HttpMessageNotReadableException ex) {
        // Esto atrapará cualquier error de lectura de JSON antes de la validación
        return ResponseEntity.badRequest().body("The JSON body is malformed or has invalid data types.");
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleBusinessLogicError(ValidationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    public record DataValidationError(String field, String message) {
        public DataValidationError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
