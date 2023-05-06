package com.example.sprintserver.sprint.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SprintDetailResponseDto {
    private final Long sprintId;
    private final String title;
    private final String content;
    private final String nickname;
    private final Integer numLikes;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final String sprintType;
    private final FieldObjectList fieldObjectList;
    @Builder
    public SprintDetailResponseDto(Long sprintId, String title,String content, String nickname, Integer numLikes, LocalDateTime createdAt, LocalDateTime modifiedAt, String sprintType, FieldObjectList fieldObject) {
        this.sprintId = sprintId;
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.numLikes = numLikes;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.sprintType = sprintType;
        this.fieldObjectList = fieldObject;
    }

}
