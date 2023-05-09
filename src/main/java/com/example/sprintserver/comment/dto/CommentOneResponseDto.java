package com.example.sprintserver.comment.dto;

import com.example.sprintserver.comment.entity.Comment;
import com.example.sprintserver.common.Message;
import com.example.sprintserver.user.entity.User;
import lombok.Getter;

@Getter
public class CommentOneResponseDto extends Message {
    CommentResponseDto commentOne;
    public CommentOneResponseDto(StatusEnum status, Comment comment, User user) {
        super(status);
        this.commentOne = new CommentResponseDto(comment, user);
    }

}