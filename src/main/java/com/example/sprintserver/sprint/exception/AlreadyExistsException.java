package com.example.sprintserver.sprint.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends CustomExceptionWithStatus {
    public AlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }

}
