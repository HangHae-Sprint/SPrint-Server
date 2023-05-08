//package com.example.sprintserver.comment.dto;
//
//import com.example.sprintserver.comment.entity.Comment;
//import lombok.Getter;
//
//import java.time.LocalDateTime;
//
//@Getter
//public class CommentResponseDto {
//    private Long id;
//    private String username;
//    private String nickname;
//    private String content;
//    private LocalDateTime createdAt;
//    private LocalDateTime modifiedAt;
//
//    public CommentResponseDto(Comment comment) {
//        this.id = comment.getId();
//        this.username = comment.getUsername();
//        this.nickname = comment.getNickname();
//        this.content = comment.getContent();;
//        this.createdAt = comment.getCreatedAt();
//        this.modifiedAt = comment.getModifiedAt();
//    }
//}
