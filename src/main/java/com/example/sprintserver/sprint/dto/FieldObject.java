package com.example.sprintserver.sprint.dto;

import com.example.sprintserver.sprint.entity.SprintFieldEntry;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class FieldObject {
    private final Map.Entry<String, Map.Entry<Integer, Integer>> fieldMaxAndNow;

    @Builder
    public FieldObject(String fieldName, Integer fieldMax, Integer fieldNow) {
        this.fieldMaxAndNow = Map.entry(fieldName, Map.entry(fieldNow, fieldMax));
    }

    public FieldObject(SprintFieldEntry entry){
        this(entry.getFieldName(), entry.getFieldMemberCount(), entry.getFieldMax());

    }
}
