package com.example.sprintserver.dependencies;

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nickname;
    private String email;

    private String password;

    @Builder
    public User(Long id, String username, String nickname, String email, String password) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public void setPassword(String new_password){ this.password = new_password; }
    public void setEmail(String new_email){ this.email = new_email;}
    public void setNickname(String new_nickname){ this.nickname = new_nickname; }
    public void setUsername(String new_username){ this.username = new_username; }

}
