package com.example.sprintserver.comment.service;

import com.example.sprintserver.comment.dto.CommentOneResponseDto;
import com.example.sprintserver.comment.dto.CommentRequestDto;
import com.example.sprintserver.comment.dto.CommentResponseDto;
import com.example.sprintserver.comment.dto.StatusEnum;
import com.example.sprintserver.comment.entity.Comment;
import com.example.sprintserver.comment.repository.CommentRepository;
import com.example.sprintserver.common.Message;
import com.example.sprintserver.sprint.dto.SprintListResponseDto;
import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.sprint.repository.SprintRepository;
import com.example.sprintserver.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final SprintRepository sprintRepository;

    @Transactional
    public Message addComment(Long id, CommentRequestDto commentRequestDto, User user) {
        // 게시글의 DB 저장 유무 확인
        Sprint sprint = sprintRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));


        // 요청 받은 DTO로 DB에 저장할 객체 만들기
        Comment comment = commentRepository.save(new Comment(commentRequestDto, sprint, user));

        return new CommentOneResponseDto(StatusEnum.OK, comment, user);
    }

    @Transactional
    public Message updateComment(Long sprintId, Long commentId, CommentRequestDto commentRequestDto, User user) {

        // 게시글의 DB 저장 유무 확인
        Sprint sprint = sprintRepository.findById(sprintId).orElseThrow(
                () -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));

//        // 사용자 권한 가져와서 ADMIN 이면 무조건 수정 가능, USER 면 본인이 작성한 댓글일 때만 수정 가능
//        UserRoleEnum userRoleEnum = user.getRole();

        Comment comment;


        comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));


        // 입력 받은 댓글 id, 토큰에서 가져온 userId와 일치하는 DB 조회
        comment = commentRepository.findByIdAndUserId(commentId, user.getId()).orElseThrow(
                () -> new IllegalArgumentException("작성자만 수정/삭제 할 수 있습니다."));



        // 요청 받은 DTO로 DB에 업데이트
        comment.update(commentRequestDto);

        return new CommentOneResponseDto(StatusEnum.OK, comment, user);
    }

    @Transactional
    public Message deleteComment(Long sprintId, Long commentId, User user) {
        // 게시글의 DB 저장 유무 확인
        Sprint sprint = sprintRepository.findById(sprintId).orElseThrow(
                () -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));


//        // 사용자 권한 가져와서 ADMIN 이면 무조건 수정 가능, USER 면 본인이 작성한 댓글일 때만 수정 가능
//        UserRoleEnum userRoleEnum = user.getRole();

        Comment comment;

//        if (userRoleEnum == UserRoleEnum.ADMIN) {
        // 입력 받은 댓글 id와 일치하는 DB 조회
        comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));

//        } else {
        // 입력 받은 댓글 id, 토큰에서 가져온 userId와 일치하는 DB 조회
        comment = commentRepository.findByIdAndUserId(commentId, user.getId()).orElseThrow(
                () -> new IllegalArgumentException("작성자만 수정/삭제 할 수 있습니다."));
//        }

        // 해당 댓글 삭제
        commentRepository.deleteById(commentId);

        return new Message(StatusEnum.OK);
    }

    @Transactional
    public List<CommentResponseDto> getCommentsOnSprint(Long sprintId, User user) {
        List<Comment> commentList = commentRepository.findAllBySprint_IdOrderByCreatedAt(sprintId);
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
        for(Comment comment: commentList){
            commentResponseDtoList.add(new CommentResponseDto(comment, user));
        }
//        return commentRepository.findAllBySprint_IdOrderByCreatedAt(sprintId).stream()
//                .map(c -> new CommentResponseDto(c, user))
//                .collect(Collectors.toList());

        return commentResponseDtoList;
    }
}