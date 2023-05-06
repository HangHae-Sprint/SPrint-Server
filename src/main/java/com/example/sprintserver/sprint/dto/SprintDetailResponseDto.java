package com.example.sprintserver.sprint.dto;

import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.sprint.entity.SprintFieldEntry;
import com.example.sprintserver.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private final List<FieldObject> fieldObjectList;
    private final Boolean isMySprint;
    @Builder
    public SprintDetailResponseDto(
            Long sprintId, String title,String content, String nickname, Integer numLikes, LocalDateTime createdAt,
            LocalDateTime modifiedAt, String sprintType, List<FieldObject> fieldObjectList, Boolean isMySprint
    ) {
        this.sprintId = sprintId;
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.numLikes = numLikes;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.sprintType = sprintType;
        this.fieldObjectList = fieldObjectList;
        this.isMySprint = isMySprint;
    }

    public SprintDetailResponseDto(Sprint sprint, List<FieldObject> fieldObjectList, User user) {

        this(
                sprint.getId(),
                sprint.getTitle(),
                sprint.getContent(),
                user.getNickname(),
                sprint.getNumLikes(),
                sprint.getCreatedAt(),
                sprint.getModifiedAt(),
                sprint.getSprintType().toString(),
                fieldObjectList,
                sprint.getUser().getId().equals(user.getId())
        );
    }
//                builder()
//                .sprintId(sprint.getId())
//                .title(sprint.getTitle())
//                .content(sprint.getContent())
//                .nickname(user.getNickname())
//                .numLikes(numLikes)
//                .createdAt(sprint.getCreatedAt())
//                .modifiedAt(sprint.getModifiedAt())
//                .sprintType(sprint.getSprintType().toString())
//                .fieldObjectList(fieldsInfo)
//                .build();







}
