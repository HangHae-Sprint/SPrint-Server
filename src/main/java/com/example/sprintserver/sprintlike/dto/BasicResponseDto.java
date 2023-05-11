package com.example.sprintserver.sprintlike.dto;

import com.example.sprintserver.sprintlike.entity.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(staticName = "set")
@Data
public class BasicResponseDto<T> {
    private StatusCode status;
    private String message;
    private T data;

    public <T> BasicResponseDto<T> setSuccess(String message, T data){
        return BasicResponseDto.set(StatusCode.OK, message, data);
    }

    public <T> BasicResponseDto<T> setBadRequest(String message){
        return BasicResponseDto.set(StatusCode.BAD_REQUEST, message, null);
    }
}
