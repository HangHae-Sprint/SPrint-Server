package com.example.sprintserver.sprint.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class SprintJoinEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long sprintId;
    private Long fieldIdx;

    @Builder
    public SprintJoinEntry(Long id,Long userId, Long sprintId, Long fieldIdx) {
        this.id = id;
        this.userId = userId;
        this.sprintId = sprintId;
        this.fieldIdx = fieldIdx;
    }

}
