package com.example.sprintserver.sprint.repository;

import com.example.sprintserver.sprint.entity.SprintFieldEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintFieldEntryRepository extends JpaRepository<SprintFieldEntry, Long> {
    List<SprintFieldEntry> findAllBySprintId(Long sprintId);
}
