package com.example.sprintserver.sprint.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class FieldNotFoundException extends CustomExceptionWithStatus{

    public FieldNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
