package com.example.sprintserver.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

//    @OneToMany
//    private List<Sprint> sprintList = new ArrayList<>();
//
//    @OneToMany
//    private List<SprintLike> sprintLikeList = new ArrayList<>();
//
//    @OneToMany
//    private List<Comment> commentList = new ArrayList<>();
//
//    @OneToMany
//    private List<Join> joinList = new ArrayList<>();


    public User(String username, String nickname, String password, String email) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }
}
