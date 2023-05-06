package com.example.sprintserver.sprint.repository;

import com.example.sprintserver.sprint.entity.SprintFieldEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintFieldCountRepository extends JpaRepository<SprintFieldEntry, Long> {
}
