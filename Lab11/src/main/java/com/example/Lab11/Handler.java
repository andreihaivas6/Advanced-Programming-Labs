package com.example.Lab11;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {
    @ExceptionHandler
    public String handleIllegalStateException(IllegalStateException exception) {
        return exception.getMessage();
    }
}
