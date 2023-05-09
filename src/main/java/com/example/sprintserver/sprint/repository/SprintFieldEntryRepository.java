package com.example.sprintserver.sprint.repository;

import com.example.sprintserver.sprint.entity.SprintFieldEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SprintFieldEntryRepository extends JpaRepository<SprintFieldEntry, Long> {
    List<SprintFieldEntry> findAllBySprintId(Long sprintId);
    Optional<SprintFieldEntry> findBySprintIdAndFieldName(Long sprintId, String fieldName);
}
