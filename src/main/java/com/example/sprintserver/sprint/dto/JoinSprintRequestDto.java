package com.example.sprintserver.sprint.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinSprintRequestDto {
    private String position;
    private String githubLink;

    public JoinSprintRequestDto(String position, String githubLink) {
        this.position = position;
        this.githubLink = githubLink;
    }
}
