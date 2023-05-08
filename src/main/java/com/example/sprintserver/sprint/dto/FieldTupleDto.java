package com.example.sprintserver.sprint.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class FieldTupleDto {
    private String fieldName;
    private Integer fieldMaxNum;
}
