package com.example.sprintserver.sprint.repository;

import com.example.sprintserver.sprint.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint,Long> {
    List<Sprint> findAllByIsDeletedFalse();
}
