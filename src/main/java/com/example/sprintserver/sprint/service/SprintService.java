package com.example.sprintserver.sprint.service;

import com.example.sprintserver.common.Message;
import com.example.sprintserver.dependencies.User;
import com.example.sprintserver.sprint.dto.PostSprintRequestDto;
import com.example.sprintserver.sprint.dto.SprintDetailResponseDto;
import com.example.sprintserver.sprint.dto.SprintListResponseDto;
import com.example.sprintserver.sprint.dto.UpdateSprintRequestDto;
import com.example.sprintserver.sprint.repository.SprintRepository;
import com.example.sprintserver.sprint.sprint_utils.SuccessResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SprintService {
    private final SprintRepository sprintRepository;
    @Transactional
    public SuccessResponseEntity<SprintListResponseDto> getAllSprintList() {
        return null;
    }


    @Transactional
    public SuccessResponseEntity<SprintDetailResponseDto> postSprint(User users, PostSprintRequestDto requestDto) {
        return null;
    }

    @Transactional
    public SuccessResponseEntity<SprintDetailResponseDto> getOneSprint(User users, Long sprintId) {
        return null;
    }

    public SuccessResponseEntity<Message> deleteSprint(User user, Long sprintId) {
        return null;
    }

    public SuccessResponseEntity<Message> joinSprint(User user, Long sprintId) {
        return null;
    }

    public SuccessResponseEntity<SprintDetailResponseDto> updateSprint(
            User user, Long sprintId, UpdateSprintRequestDto requestDto
    ) {
        return null;
    }
}
