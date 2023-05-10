package com.example.sprintserver.sprintlike.repository;

import com.example.sprintserver.sprintlike.entity.SprintLike;
import com.example.sprintserver.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SprintLikeRepository extends JpaRepository<SprintLike, Long> {
    Optional<SprintLike> findByUser_IdAndSprint_Id(Long user_id, Long sprint_id);
    List<SprintLike> findAllByUser(User user);
}
