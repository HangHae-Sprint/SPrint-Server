package com.example.sprintserver.sprint.controller;

import com.example.sprintserver.common.Message;
import com.example.sprintserver.sprint.dto.*;
import com.example.sprintserver.sprint.service.SprintService;
import com.example.sprintserver.sprint.sprint_utils.SuccessResponseEntity;
import com.example.sprintserver.user.entity.User;
import com.example.sprintserver.common.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sprint")
public class SprintController {
    private final SprintService sprintService;
    @GetMapping  // 모든 sprint 조회
    public SuccessResponseEntity<SprintListResponseDto> getAllSprintList(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        User user = userDetails.getUser();
        return sprintService.getAllSprintList();
    }

    @PostMapping // sprint 등록
    public SuccessResponseEntity<SprintDetailResponseDto> postSprint(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody PostSprintRequestDto requestDto
    ){
        User user = userDetails.getUser();
        return sprintService.postSprint(user, requestDto);
    }

    @GetMapping("/{sprintId}") // sprint 상세조회
    public SuccessResponseEntity<SprintDetailResponseDto> getOneSprint(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long sprintId
    ){
        User user = userDetails.getUser();
        return sprintService.getOneSprint(user, sprintId);
    }

    @PutMapping("/{sprintId}") // sprint 수정
    public SuccessResponseEntity<SprintDetailResponseDto> updateSprint(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long sprintId,
            @RequestBody UpdateSprintRequestDto requestDto
    ){
        User user = userDetails.getUser();
        return sprintService.updateSprint(user, sprintId, requestDto);
    }

    @DeleteMapping("/{sprintId}") // sprint 삭제요청
    public SuccessResponseEntity<Message> deleteSprint(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long sprintId
    ){
        User user = userDetails.getUser();
        return sprintService.deleteSprint(user, sprintId);
    }

    @PostMapping("/join/{sprintId}")
    public SuccessResponseEntity<Message> joinSprint(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long sprintId,
            @RequestBody joinSprintRequestDto requestDto
            ){
        User user = userDetails.getUser();
        return sprintService.joinSprint(user, sprintId);
    }



}
