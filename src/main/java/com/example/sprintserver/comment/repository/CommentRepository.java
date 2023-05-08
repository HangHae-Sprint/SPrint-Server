package com.example.sprintserver.comment.repository;

import com.example.sprintserver.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllBySprint_IdOrderByCreatedAt(Long SPRINT_ID);
    void deleteAllBySprint_Id(Long SPRINT_ID);
    Optional<Comment> findByIdAndUserId(Long CommentId, Long UserId);
}