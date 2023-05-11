package com.example.sprintserver.sprint.entity;

import com.example.sprintserver.common.Timestamped;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class SprintJoinEntry extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long sprintId;

    @Column(nullable = false)
    private Integer fieldIdx;

    @Column(nullable = false)
    private String githubLink;

    @Builder
    public SprintJoinEntry(Long userId, Long sprintId, Integer fieldIdx, String githubLink) {
        this.userId = userId;
        this.sprintId = sprintId;
        this.fieldIdx = fieldIdx;
        this.githubLink = githubLink;
    }

}
