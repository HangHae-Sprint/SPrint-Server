package com.example.sprintserver.comment.dto;

public enum StatusEnum {

    OK(200, "성공");

    public final Integer statuscode;
    public final String msg;

    StatusEnum(Integer statuscode, String msg) {
        this.statuscode = statuscode;
        this.msg = msg;
    }

}