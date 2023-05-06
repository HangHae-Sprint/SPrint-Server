package com.example.sprintserver.sprint.exception;

import org.springframework.http.HttpStatus;

public class InvalidParameterException extends RuntimeException{
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public InvalidParameterException(String message) {
        super(message);
    }
}
