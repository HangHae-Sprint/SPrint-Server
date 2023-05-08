package com.example.sprintserver.sprintlike.repository;

import com.example.sprintserver.sprintlike.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintLikeRepository extends JpaRepository<Like, Long> {
    boolean existsBySprintIdAndUserId(Long sprint_id, Long user_id);
    Like findBySprintIdAndUserId(Long sprint_id, Long user_id);

}
