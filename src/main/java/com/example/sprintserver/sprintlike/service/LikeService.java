package com.example.sprintserver.sprintlike.service;

import com.example.sprintserver.common.Message;
import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.sprint.service.SprintService;
import com.example.sprintserver.sprintlike.entity.sprintLike;
import com.example.sprintserver.sprintlike.repository.SprintLikeRepository;
import com.example.sprintserver.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeService {

    private final SprintLikeRepository sprintLikeRepository;
    private final SprintService sprintService;

    public Message sprintLike(Long sprintId, User user) {

        Sprint sprint = sprintService.loadSprintById(sprintId);
        String msg;

        Optional<sprintLike> like = sprintLikeRepository.findByUser_IdAndSprint_Id(user.getId(), sprint.getId());
        if (like.isPresent()) {
            sprintLikeRepository.delete(like.get());
            sprint.updateLike(false);
            msg = "스프린트 좋아요 취소";
        } else {
            sprintLikeRepository.save(new sprintLike(user, sprint));
            sprint.updateLike(true);
            msg = "스프린트 좋아요";
        }
        return new Message(msg, HttpStatus.OK);
    }
}