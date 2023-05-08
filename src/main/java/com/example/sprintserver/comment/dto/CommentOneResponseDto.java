package com.example.sprintserver.comment.dto;

import com.example.sprintserver.comment.entity.Comment;
import com.example.sprintserver.common.Message;
import lombok.Getter;

@Getter
public class CommentOneResponseDto extends Message {
    CommentResponseDto commentOne;
    public CommentOneResponseDto(StatusEnum status, Comment comment) {
        super(status);
        this.commentOne = new CommentResponseDto(comment);
    }

}