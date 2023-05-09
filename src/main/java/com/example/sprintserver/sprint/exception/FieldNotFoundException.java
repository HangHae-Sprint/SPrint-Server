package com.example.sprintserver.sprint.exception;

import lombok.Getter;

@Getter
public class FieldNotFoundException extends RuntimeException{

    public FieldNotFoundException(String message) {
        super(message);
    }
}
