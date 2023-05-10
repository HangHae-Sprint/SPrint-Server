package com.example.sprintserver.sprint.entity;


import com.example.sprintserver.common.Timestamped;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class SprintFieldEntry extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Sprint sprint;

    @Column(nullable = false)
    private Integer fieldIdx;

    @Column(nullable = false)
    private String fieldName;

    @Column(nullable = false)
    private Integer fieldMax;

    @Column(nullable = false)
    private Integer fieldMemberCount = 0;

    @Builder
    public SprintFieldEntry(Sprint sprint, Integer fieldIdx, String fieldName, Integer fieldMax) {
        this.sprint = sprint;
        this.fieldIdx = fieldIdx;
        this.fieldName = fieldName;
        this.fieldMax = fieldMax;
    }

    public void setFieldName(String new_fieldName){ this.fieldName = new_fieldName; }
    public void setFieldMax(Integer new_fieldMax){ this.fieldMax = new_fieldMax; }
    public void addFieldMember(){ this.fieldMemberCount++; }
    public void minusFieldMember(){ this.fieldMemberCount--; }
}
