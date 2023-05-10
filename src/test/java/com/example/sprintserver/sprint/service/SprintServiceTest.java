package com.example.sprintserver.sprint.service;

import com.example.sprintserver.comment.repository.CommentRepository;
import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.sprint.entity.SprintFieldEntry;
import com.example.sprintserver.sprint.repository.SprintFieldEntryRepository;
import com.example.sprintserver.sprint.repository.SprintJoinEntryRepository;
import com.example.sprintserver.sprint.repository.SprintRepository;
import com.example.sprintserver.sprintlike.repository.SprintLikeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SprintServiceTest {

    @Mock
    SprintRepository sprintRepository;
    SprintFieldEntryRepository fieldEntryRepository;
    CommentRepository commentRepository;
    SprintJoinEntryRepository joinEntryRepository;
    SprintLikeRepository likeRepository;


    @Test
    void getAllSprintList() {
    }

    @Test
    void postSprint() {
    }

    @Test
    void getOneSprint() {
    }

    @Test
    void deleteSprint() {
    }

    @Test
    void joinSprint() {
    }

    @Test
    void updateSprint() {
    }

    @Test
    void getMySprintList() {
    }

    @Test
    void getJoinList() {
    }
}