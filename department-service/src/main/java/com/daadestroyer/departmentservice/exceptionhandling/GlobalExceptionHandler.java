package com.daadestroyer.departmentservice.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        String message = resourceNotFoundException.getMessage();
        APIResponse apiResponse = APIResponse.builder().message(message).status("failed").build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistedException.class)
    public ResponseEntity<?> handleResourceAlreadyExistedException(ResourceAlreadyExistedException resourceAlreadyExistedException) {
        String message = resourceAlreadyExistedException.getMessage();
        APIResponse apiResponse = APIResponse.builder().message(message).status("failed").build();
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HashMap<String, String> hashMap = new HashMap<>();
        ex.getAllErrors().forEach((error) -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            hashMap.put(field, message);
        });
        return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
    }

}
