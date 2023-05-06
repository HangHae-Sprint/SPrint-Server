package com.example.sprintserver.comment.entity;

import com.example.sprintserver.comment.dto.CommentRequestDto;
import com.example.sprintserver.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SPRINT_ID", nullable = false)
    private Sprint sprint;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String content;


    public Comment(CommentRequestDto commentRequestDto, Sprint sprint, User user) {
        this.content = commentRequestDto.getContent();
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.sprint = sprint;
        this.user = user;
    }

    public void update(CommentRequestDto commentRequestDto) {
        this.comment = commentRequestDto.getComment();
    }
}
