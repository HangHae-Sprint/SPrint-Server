package com.example.sprintserver.sprint.repository;

import com.example.sprintserver.sprint.entity.SprintJoinEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintJoinEntryRepository extends JpaRepository<SprintJoinEntry, Long> {
    Boolean existsByUserIdAndSprintId(Long userId, Long sprintId);
    List<SprintJoinEntry> findAllByUserId(Long userId);

}
