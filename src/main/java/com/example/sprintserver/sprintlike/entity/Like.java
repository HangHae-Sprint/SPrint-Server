package com.example.sprintserver.sprintlike.entity;

import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.users.entiy.User;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    public Like(User user, Sprint sprint) {
        this.user = user;
        this.sprint = sprint;
    }

    public static Like of(User user, Sprint sprint) {
        return new Like(user, sprint);
    }

}
