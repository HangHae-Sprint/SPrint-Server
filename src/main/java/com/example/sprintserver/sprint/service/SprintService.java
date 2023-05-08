package com.example.sprintserver.sprint.service;

import com.example.sprintserver.comment.dto.CommentResponseDto;
import com.example.sprintserver.comment.entity.Comment;
import com.example.sprintserver.comment.service.CommentService;
import com.example.sprintserver.common.Message;
import com.example.sprintserver.sprint.dto.*;
import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.sprint.entity.SprintFieldEntry;
import com.example.sprintserver.sprint.exception.SprintNotFoundException;
import com.example.sprintserver.sprint.repository.SprintFieldEntryRepository;
import com.example.sprintserver.sprint.repository.SprintRepository;
import com.example.sprintserver.sprint.sprint_utils.SuccessResponseEntity;
import com.example.sprintserver.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SprintService {
    private final SprintRepository sprintRepository;
    private final SprintFieldEntryRepository sprintFieldEntryRepository;
    private final CommentService commentService;
    @Transactional
    public SuccessResponseEntity<SprintListResponseDto> getAllSprintList(User user) {  //리팩토링 대상
        System.out.println("체크포인트1");
        List<Sprint> sprintList = sprintRepository.findAll();
        System.out.println("체크포인트2");
        Map<Long, List<SprintFieldEntry>> sprintEntryMap = sprintFieldEntryRepository.findAll()
                .stream()
                .filter(e -> e.getFieldIdx() != null)
                .collect(Collectors.groupingBy(s -> s.getSprint().getId()));

        List<SprintListResponseDto> responseContainer = new ArrayList<>();
        for(Sprint sprint:sprintList){
            List<SprintFieldEntry> entries = sprintEntryMap.get(sprint.getId());
            List<FieldObject> fieldObjectList = makeFieldObjectList(entries);
            SprintListResponseDto responseDto = new SprintListResponseDto(sprint, fieldObjectList, user);
            responseContainer.add(responseDto);
        }

        return new SuccessResponseEntity<>(responseContainer, HttpStatus.OK);
    }

    @Transactional
    public SuccessResponseEntity<SprintDetailResponseDto> postSprint(
            User user, PostSprintRequestDto requestDto // Transaction 확인해보고, 쿼리 중복으로 안 나갈 시 getOneSprint로 반환하기
    ) {
        Sprint new_sprint = requestDto.toSprintEntity(user);
        System.out.println("requestDto.getFieldsInfo() = " + requestDto.getFieldInfoList());
        sprintRepository.save(new_sprint);
        List<SprintFieldEntry> sprintFieldEntries = requestDto.toSprintFieldEntryList(new_sprint);
        sprintFieldEntryRepository.saveAll(sprintFieldEntries);

        List<FieldObject> fieldObjectList = makeFieldObjectList(sprintFieldEntries);
        SprintDetailResponseDto responseDto = new SprintDetailResponseDto(new_sprint, fieldObjectList, user);

        return new SuccessResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @Transactional
    public SuccessResponseEntity<SprintDetailResponseDto> getOneSprint(
            User user, Long sprintId
    ) {
        Sprint sprint = loadSprintById(sprintId);    //나중에 쿼리 한번으로 리팩토링
        List<SprintFieldEntry> entries = loadFieldsBySprintId(sprintId);
        List<FieldObject> fieldObjectList = makeFieldObjectList(entries);
        SprintDetailResponseDto responseDto = new SprintDetailResponseDto(sprint,fieldObjectList, user);
        //        List<CommentResponseDto> comments = commentService.getCommentsOnSprint(sprintId, user);

        return new SuccessResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public SuccessResponseEntity<Message> deleteSprint(
            User user, Long sprintId
    ) {
        return null;
    }

    public SuccessResponseEntity<Message> joinSprint(
            User user, Long sprintId
    ) {
        return null;
    }

    public SuccessResponseEntity<SprintDetailResponseDto> updateSprint(
            User user, Long sprintId, UpdateSprintRequestDto requestDto
    ) {
        return null;
    }


    ////////////////내부 메소드들////////////////////////

    private Sprint loadSprintById(Long sprintId){
        return sprintRepository.findById(sprintId).orElseThrow(
                () -> new SprintNotFoundException("SprintId not found")
        );
    }
    private List<SprintFieldEntry> loadFieldsBySprintId(Long sprintId){
        return sprintFieldEntryRepository.findAllBySprintId(sprintId);
    }

    private List<FieldObject> makeFieldObjectList(List<SprintFieldEntry> entries) {
        return entries.stream()
                .map(FieldObject::new)
                .collect(Collectors.toList());
    }
}
