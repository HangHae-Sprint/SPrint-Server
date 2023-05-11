package com.example.sprintserver.common.ExceptionHandler;


import com.example.sprintserver.common.Message;
import com.example.sprintserver.common.ResponseEntity.FailResponseEntity;
import com.example.sprintserver.sprint.exception.CustomExceptionWithStatus;
import com.example.sprintserver.sprint.sprint_utils.SprintMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomExceptionWithStatus.class)
    public FailResponseEntity<SprintMessage> customExceptionHandler(CustomExceptionWithStatus e){
        return new FailResponseEntity<>(new SprintMessage(e.getMessage()), e.getHttpStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Message> runtimeExceptionHandlerWithDefaultStatus(RuntimeException e){
        return new ResponseEntity<>(new Message(e.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
}
