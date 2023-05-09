package com.example.sprintserver.sprint.sprint_utils;

public enum MessageEnum {
    DELETED("삭제되었습니다"),
    APPLIED("신청되었습니다"),
    JOINED("가입되었습니다");



        private final String message;


        MessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
