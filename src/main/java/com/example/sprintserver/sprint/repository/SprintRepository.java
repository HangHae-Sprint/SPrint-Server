package com.example.sprintserver.sprint.repository;

import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint,Long> {
    List<Sprint> findAllByIsDeletedFalse();
    List<Sprint> findAllByUserAndIsDeletedFalse(User user);

    List<Sprint> findAllByIsDeletedFalseAndIdIn(List<Long> sprintIdList);
}
