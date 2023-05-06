package com.example.sprintserver.sprint.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class SprintListResponseDto {
    private final Long sprintId;
    private final String title;
    private final String nickname;
    private final Integer numLikes;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final String sprintType;
    private final List<FieldObject> fieldObjectList;
    @Builder
    public SprintListResponseDto(
            Long sprintId, String title, String nickname, Integer numLikes,
            LocalDateTime createdAt, LocalDateTime modifiedAt, String sprintType, List<FieldObject> fieldObjects
    ) {
        this.sprintId = sprintId;
        this.title = title;
        this.nickname = nickname;
        this.numLikes = numLikes;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.sprintType = sprintType;
        this.fieldObjectList = fieldObjects;
    }
}
