package com.example.sprintserver.sprintlike.entity;

import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "likes")
@NoArgsConstructor
public class sprintLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    public sprintLike(User user, Sprint sprint) {
        this.user = user;
        this.sprint = sprint;
    }

}
