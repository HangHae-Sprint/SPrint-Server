package com.example.sprintserver.sprint.entity;


import com.example.sprintserver.dependencies.User;
import com.example.sprintserver.sprint.enums.SprintTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user_id;
    private SprintTypeEnum sprintType;
    private String title;
    private String content;
    private Boolean isDeleted;
    private Integer numLikes;

    @Builder
    public Sprint(Long id, User user, SprintTypeEnum sprintType, String title, String content, Boolean isDeleted, Integer numLikes) {
        this.id = id;
        this.user_id = user;
        this.sprintType = sprintType;
        this.title = title;
        this.content = content;
        this.isDeleted = isDeleted;
        this.numLikes = numLikes;
    }

    public void setTitle(String new_title){ this.title = new_title; }
    public void setContent(String new_content) { this.content = new_content; }
    public void flagDeleted(){ this.isDeleted = true; }
    public void setSprintType(SprintTypeEnum new_type) { this.sprintType = new_type; }
}
