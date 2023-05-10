package com.example.sprintserver.sprint.sprint_utils;

import lombok.Getter;

@Getter
public class SprintMessage {
    private final String message;

    public SprintMessage(MessageEnum messageEnum) {
        this.message = messageEnum.getMessage();
    }

    public SprintMessage(String message) {
        this.message = message;
    }
}
