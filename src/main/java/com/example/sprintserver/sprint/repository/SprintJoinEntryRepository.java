package com.example.sprintserver.sprint.repository;

import com.example.sprintserver.sprint.entity.SprintJoinEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintJoinEntryRepository extends JpaRepository<SprintJoinEntry, Long> {
    Boolean existsByUserIdAndSprintId(Long userId, Long sprintId);

}
