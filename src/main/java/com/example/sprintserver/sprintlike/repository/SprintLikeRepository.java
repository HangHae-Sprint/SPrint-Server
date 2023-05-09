package com.example.sprintserver.sprintlike.repository;

import com.example.sprintserver.sprintlike.entity.sprintLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SprintLikeRepository extends JpaRepository<sprintLike, Long> {
    Optional<sprintLike> findByUser_IdAndSprint_Id(Long user_id, Long sprint_id);
}
