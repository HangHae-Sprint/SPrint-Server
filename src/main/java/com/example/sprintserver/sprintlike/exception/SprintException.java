package com.example.sprintserver.sprintlike.exception;

public class SprintException extends RuntimeException {
    public SprintException() {
        super();
    }

    public SprintException(String message) {
        super(message);
    }

    public SprintException(String message, Throwable cause) {
        super(message, cause);
    }

    public SprintException(Throwable cause) {
        super(cause);
    }
}
