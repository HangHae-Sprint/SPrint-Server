package com.example.sprintserver.sprint.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class FieldTupleDto {
    private final String fieldName;
    private final Integer fieldMaxNum;

    public FieldTupleDto(String fieldName, Integer fieldMaxNum) {
        this.fieldName = fieldName;
        this.fieldMaxNum = fieldMaxNum;
    }
}
