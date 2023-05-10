package com.example.sprintserver.sprint.controller;

import com.example.sprintserver.common.security.UserDetailsImpl;
import com.example.sprintserver.sprint.dto.*;
import com.example.sprintserver.sprint.service.SprintService;
import com.example.sprintserver.sprint.sprint_utils.SprintMessage;
import com.example.sprintserver.common.ResponseEntity.SuccessResponseEntity;
import com.example.sprintserver.user.entity.User;
import com.example.sprintserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sprint")
public class SprintController {
    private final SprintService sprintService;
    private final UserRepository userRepository;    // 임시코드
    @GetMapping  // 모든 sprint 조회
    public ResponseEntity<List<SprintListResponseDto>> getAllSprintList(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        User user;
        if(userDetails == null){
            user = userRepository.findById(38L).orElseThrow(() -> new IllegalArgumentException("ananymous없음"));
        }
        else{
            user = userDetails.getUser();
        }
//        User user = userDetails.getUser();

        return sprintService.getAllSprintList(user);
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
            @RequestBody SprintUpdateRequestDto requestDto
    ){
        User user = userDetails.getUser();
        return sprintService.updateSprint(user, sprintId, requestDto);
    }

    @DeleteMapping("/{sprintId}") // sprint 삭제요청
    public SuccessResponseEntity<SprintMessage> deleteSprint(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long sprintId
    ){
        User user = userDetails.getUser();
        return sprintService.deleteSprint(user, sprintId);
    }

    @PostMapping("/join/{sprintId}") // sprint 참여요청
    public SuccessResponseEntity<SprintMessage> joinSprint(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long sprintId,
            @RequestBody JoinSprintRequestDto requestDto
            ){
        User user = userDetails.getUser();
        return sprintService.joinSprint(user, sprintId, requestDto);
    }

    @GetMapping("/mysprint")
    public SuccessResponseEntity<List<SprintListResponseDto>> getMySprintList(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        User user = userDetails.getUser();
        return sprintService.getMySprintList(user);
    }

    @GetMapping("/joinlist")
    public SuccessResponseEntity<List<SprintListResponseDto>> getJoinList(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        User user = userDetails.getUser();
        return sprintService.getJoinList(user);
    }



}
