package com.example.sprintserver.comment.dto;

public enum StatusEnum {

    OK(200, "성공");

    int statuscode;
    String msg;

    StatusEnum(int statuscode, String msg) {
        this.statuscode = statuscode;
        this.msg = msg;
    }

}
