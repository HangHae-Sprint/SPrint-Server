package com.example.sprintserver.sprint.exception;

import org.springframework.http.HttpStatus;

public class DeletedSprintException extends CustomExceptionWithStatus{
    public DeletedSprintException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
