package com.example.sprintserver.sprint.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SprintUpdateRequestDto {
    private String title;
    private String content;
}
