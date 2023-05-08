package com.example.sprintserver.common;

import com.example.sprintserver.comment.dto.StatusEnum;
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

    public Message(StatusEnum status) {
        this.statuscode = status.statuscode;
        this.msg = status.msg;
    }
}
