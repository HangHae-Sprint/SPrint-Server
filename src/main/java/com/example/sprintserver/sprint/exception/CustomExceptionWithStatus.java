package com.example.sprintserver.sprint.exception;

import org.springframework.http.HttpStatus;

public class CustomExceptionWithStatus extends RuntimeException{
    private final HttpStatus httpStatus;

    public CustomExceptionWithStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public CustomExceptionWithStatus(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
