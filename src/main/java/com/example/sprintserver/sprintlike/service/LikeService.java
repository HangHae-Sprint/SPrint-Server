package com.example.sprintserver.sprintlike.service;

import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.sprint.repository.SprintRepository;
import com.example.sprintserver.sprintlike.dto.BasicResponseDto;
import com.example.sprintserver.sprintlike.entity.Like;
import com.example.sprintserver.sprintlike.exception.ExceptionMessage;
import com.example.sprintserver.sprintlike.exception.SprintException;
import com.example.sprintserver.sprintlike.repository.SprintLikeRepository;
import com.example.sprintserver.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeService {

    private final SprintRepository sprintRepository;
    private final SprintLikeRepository sprintLikeRepository;


    public ResponseEntity sprintLike(Long sprintId, User user) {
        Sprint sprint = validateSprint(sprintId);

        // 좋아요 유무 확인
        if (sprintLikeRepository.existsBySprintIdAndUserId(sprintId, user.getId())) {
            Like like = sprintLikeRepository.findBySprintIdAndUserId(sprintId, user.getId());
            sprintLikeRepository.delete(like);
            sprint.updateLike(false);
        } else {
            sprintLikeRepository.save(new Like(user, sprint));
            sprint.updateLike(true);
        }
        BasicResponseDto basicResponseDto = BasicResponseDto.setSuccess("like update 완료", null);
        return new ResponseEntity(basicResponseDto, HttpStatus.OK);

    }

    private Sprint validateSprint(Long id) {
        return sprintRepository.findById(id).orElseThrow(
                () -> new SprintException(ExceptionMessage.NO_SUCH_BOARD_EXCEPTION.getMessage()));
    }

}
g