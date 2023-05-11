package com.example.sprintserver.common.ResponseEntity;

import com.example.sprintserver.common.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class SuccessResponseEntity<T> extends ResponseEntity<T> {
    public SuccessResponseEntity(HttpStatus status) {
        super(status);
    }

    public SuccessResponseEntity(T body, HttpStatus status) {
        super(body, status);
    }

}
