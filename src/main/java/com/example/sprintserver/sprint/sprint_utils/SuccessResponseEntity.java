package com.example.sprintserver.sprint.sprint_utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class SuccessResponseEntity<T> extends ResponseEntity {
    public SuccessResponseEntity(HttpStatus status) {
        super(status);
    }

    public SuccessResponseEntity(Object body, HttpStatus status) {
        super(body, status);
    }

    public SuccessResponseEntity(MultiValueMap headers, HttpStatus status) {
        super(headers, status);
    }

    public SuccessResponseEntity(Object body, MultiValueMap headers, HttpStatus status) {
        super(body, headers, status);
    }

    public SuccessResponseEntity(Object body, MultiValueMap headers, int rawStatus) {
        super(body, headers, rawStatus);
    }
}
