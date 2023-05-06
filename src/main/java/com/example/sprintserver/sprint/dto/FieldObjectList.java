package com.example.sprintserver.sprint.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class FieldObjectList {
    private List<Map.Entry<String, Integer>> fieldStatus = new ArrayList<>();

    public void addField(String fieldName, Integer fieldMerberCount){
        this.fieldStatus.add(Map.entry(fieldName, fieldMerberCount));
    }
}
