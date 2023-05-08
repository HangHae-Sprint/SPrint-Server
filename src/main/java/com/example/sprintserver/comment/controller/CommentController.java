//package com.example.sprintserver.comment.controller;
//
//import com.example.sprintserver.comment.dto.CommentRequestDto;
//import com.example.sprintserver.comment.service.CommentService;
//import com.example.sprintserver.common.Message;
//import com.example.sprintserver.dto.BaseResponse;
//import com.example.sprintserver.dto.CommentRequestDto;
//import com.example.sprintserver.security.UserDetailsImpl;
//import com.example.sprintserver.service.CommentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//
//@RestController
//@RequestMapping("/api/comment")
//@RequiredArgsConstructor
//public class CommentController {
//
//    private final CommentService commentService;
//
//    // 댓글 작성
//    @PostMapping("/{id}")
//    public ResponseEntity<Message> addComment(
//            @PathVariable Long id,
//            @RequestBody CommentRequestDto commentRequestDto,
//            @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return ResponseEntity.ok().body(commentService.addComment(id, commentRequestDto, userDetails.getUser()));
//    }
//
//    // 댓글 수정
//    @PutMapping("/{boardId}/{cmtId}")
//    public ResponseEntity<Message> updateComment(
//            @PathVariable Long boardId,
//            @PathVariable Long cmtId,
//            @RequestBody CommentRequestDto commentRequestDto,
//            @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return ResponseEntity.ok().body(commentService.updateComment(boardId, cmtId, commentRequestDto, userDetails.getUser()));
//    }
//
//    // 댓글 삭제
//    @DeleteMapping("/{boardId}/{cmtId}")
//    public ResponseEntity<Message> deleteComment(
//            @PathVariable Long boardId,
//            @PathVariable Long cmtId,
//            @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return ResponseEntity.ok().body(commentService.deleteComment(boardId, cmtId, userDetails.getUser()));
//    }
//}
