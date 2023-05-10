package com.example.sprintserver.common.ResponseEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class FailResponseEntity<T> extends ResponseEntity<T> {

    public FailResponseEntity(HttpStatus status) {
        super(status);
    }

    public FailResponseEntity(T body, HttpStatus status) {
        super(body, status);
    }
}
