package com.example.sprintserver.comment.dto;

import com.example.sprintserver.comment.entity.Comment;
import com.example.sprintserver.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private String nickname;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean isMyComment;

    public CommentResponseDto(Comment comment, User user) {
        this.id = comment.getId();
        this.nickname = comment.getNickname();
        this.content = comment.getContent();;
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.isMyComment = comment.getUser().getId().equals(user.getId());

    }
}
