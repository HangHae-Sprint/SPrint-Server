package com.example.sprintserver.sprint.repository;

import com.example.sprintserver.sprint.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint,Long> {
}