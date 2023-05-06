package com.example.sprintserver.sprint.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class SprintFieldEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sprintId;
    private Integer fieldIdx;
    private String fieldName;
    private Integer fieldMax;
    private Integer fieldMemberCount;

    @Builder
    public SprintFieldEntry(Long sprintId, Integer fieldIdx, String fieldName, Integer fieldMax, Integer fieldMemberCount) {
        this.sprintId = sprintId;
        this.fieldIdx = fieldIdx;
        this.fieldName = fieldName;
        this.fieldMax = fieldMax;
        this.fieldMemberCount = fieldMemberCount;
    }

    public void setFieldName(String new_fieldName){ this.fieldName = new_fieldName; }
    public void setFieldMax(Integer new_fieldMax){ this.fieldMax = new_fieldMax; }
    public void addFieldMember(){ this.fieldMemberCount++; }
    public void minusFieldMember(){ this.fieldMemberCount--; }
}
