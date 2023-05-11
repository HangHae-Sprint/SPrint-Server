package com.example.sprintserver.sprint.exception;

import org.springframework.http.HttpStatus;

public class UnAuthorizedRequestException extends CustomExceptionWithStatus{
    public UnAuthorizedRequestException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
