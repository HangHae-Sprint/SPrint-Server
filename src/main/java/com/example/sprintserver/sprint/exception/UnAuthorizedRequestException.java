package com.example.sprintserver.sprint.exception;

public class UnAuthorizedRequestException extends RuntimeException{
    public UnAuthorizedRequestException(String message) {
        super(message);
    }
}
