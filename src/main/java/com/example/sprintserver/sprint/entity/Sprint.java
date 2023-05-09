package com.example.sprintserver.sprint.entity;



import com.example.sprintserver.common.Timestamped;
import com.example.sprintserver.sprint.enums.SprintTypeEnum;
import com.example.sprintserver.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Sprint extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    private SprintTypeEnum sprintType;
    private String title;
    private String content;
    private Boolean isDeleted = false;
    private Integer numLikes = 0;

    @Builder
    public Sprint(Long id, User user, SprintTypeEnum sprintType, String title, String content) {
        this.id = id;
        this.user = user;
        this.sprintType = sprintType;
        this.title = title;
        this.content = content;
    }

    public void setTitle(String new_title){ this.title = new_title; }
    public void setContent(String new_content) { this.content = new_content; }
    public void setDeleted(Boolean isDeleted){ this.isDeleted = isDeleted; }
    public void setSprintType(SprintTypeEnum new_type) { this.sprintType = new_type; }
}
