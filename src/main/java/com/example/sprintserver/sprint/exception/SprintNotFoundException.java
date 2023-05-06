package com.example.sprintserver.sprint.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SprintNotFoundException extends RuntimeException{
    private final HttpStatus status = HttpStatus.NOT_FOUND;
    public SprintNotFoundException(String message) {
        super(message);
    }
}
