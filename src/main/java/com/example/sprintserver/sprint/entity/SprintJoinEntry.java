package com.example.sprintserver.sprint.entity;

import com.example.sprintserver.common.Timestamped;
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
public class SprintJoinEntry extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long sprintId;
    private Integer fieldIdx;
    private String githubLink;

    @Builder
    public SprintJoinEntry(Long userId, Long sprintId, Integer fieldIdx, String githubLink) {
        this.userId = userId;
        this.sprintId = sprintId;
        this.fieldIdx = fieldIdx;
        this.githubLink = githubLink;
    }

}
