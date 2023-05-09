package com.example.sprintserver.sprint.exception;

public class DeletedSprintException extends RuntimeException{
    public DeletedSprintException(String message) {
        super(message);
    }
}
