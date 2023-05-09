package com.example.sprintserver.sprint.exception;

public class FieldAlreadyFullException extends RuntimeException{
    public FieldAlreadyFullException(String message) {
        super(message);
    }
}
