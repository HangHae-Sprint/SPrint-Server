package com.example.sprintserver.sprint.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SprintNotFoundException extends CustomExceptionWithStatus{
    public SprintNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
