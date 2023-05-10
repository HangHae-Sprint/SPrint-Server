package com.example.sprintserver.sprint.exception;

import org.springframework.http.HttpStatus;

public class FieldAlreadyFullException extends CustomExceptionWithStatus{
    public FieldAlreadyFullException(String message) {
        super(message, HttpStatus.NOT_ACCEPTABLE);
    }
}
