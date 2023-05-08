package com.example.sprintserver.sprint.entity;


import com.example.sprintserver.common.Timestamped;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.swing.*;

@Entity
@NoArgsConstructor
@Getter
public class SprintFieldEntry extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Sprint sprint;
    private Integer fieldIdx;
    private String fieldName;
    private Integer fieldMax;
    private Integer fieldMemberCount = 0;

    @Builder
    public SprintFieldEntry(Sprint sprint, Integer fieldIdx, String fieldName, Integer fieldMax, Integer fieldMemberCount) {
        this.sprint = sprint;
        this.fieldIdx = fieldIdx;
        this.fieldName = fieldName;
        this.fieldMax = fieldMax;
//        this.fieldMemberCount = fieldMemberCount;
    }

    public void setFieldName(String new_fieldName){ this.fieldName = new_fieldName; }
    public void setFieldMax(Integer new_fieldMax){ this.fieldMax = new_fieldMax; }
    public void addFieldMember(){ this.fieldMemberCount++; }
    public void minusFieldMember(){ this.fieldMemberCount--; }
}
