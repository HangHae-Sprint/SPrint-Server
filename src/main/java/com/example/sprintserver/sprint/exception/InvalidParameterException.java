package com.example.sprintserver.sprint.exception;

import org.springframework.http.HttpStatus;

public class InvalidParameterException extends CustomExceptionWithStatus{
    public InvalidParameterException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
