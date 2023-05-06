package com.example.sprintserver.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Message {
    private final String msg;
    private final Integer statuscode;


    public Message(String messageToClient, HttpStatus httpStatus) {
        this.msg = messageToClient;
        this.statuscode = httpStatus.value();
    }

}
