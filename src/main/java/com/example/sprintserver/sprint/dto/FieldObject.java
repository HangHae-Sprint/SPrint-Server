package com.example.sprintserver.sprint.dto;

import com.example.sprintserver.sprint.entity.SprintFieldEntry;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FieldObject {
    private final String fieldName;
    private final Integer nowMemberCount;
    private final Integer fieldMaxNum;

    @Builder
    public FieldObject(String fieldName, Integer fieldNow, Integer fieldMax) {
        this.fieldName = fieldName;
        this.nowMemberCount = fieldNow;
        this.fieldMaxNum = fieldMax;
    }

    public FieldObject(SprintFieldEntry entry){
        this(entry.getFieldName(), entry.getFieldMemberCount(), entry.getFieldMax());

    }
}
