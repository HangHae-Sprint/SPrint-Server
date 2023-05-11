package com.example.sprintserver.sprint.exception;

import org.springframework.http.HttpStatus;

public class MySprintException extends CustomExceptionWithStatus{
    public MySprintException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
