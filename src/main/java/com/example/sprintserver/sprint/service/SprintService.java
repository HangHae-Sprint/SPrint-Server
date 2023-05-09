package com.example.sprintserver.sprint.service;

import com.example.sprintserver.comment.dto.CommentResponseDto;
import com.example.sprintserver.comment.service.CommentService;
import com.example.sprintserver.sprint.dto.*;
import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.sprint.entity.SprintFieldEntry;
import com.example.sprintserver.sprint.entity.SprintJoinEntry;
import com.example.sprintserver.sprint.exception.*;
import com.example.sprintserver.sprint.repository.SprintFieldEntryRepository;
import com.example.sprintserver.sprint.repository.SprintJoinEntryRepository;
import com.example.sprintserver.sprint.repository.SprintRepository;
import com.example.sprintserver.sprint.sprint_utils.MessageEnum;
import com.example.sprintserver.sprint.sprint_utils.SprintMessage;
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
    private final SprintFieldEntryRepository fieldEntryRepository;
    private final CommentService commentService;
    private final SprintJoinEntryRepository joinEntryRepository;
    @Transactional
    public SuccessResponseEntity<List<SprintListResponseDto>> getAllSprintList(User user) {  //리팩토링 대상
        List<Sprint> sprintList = sprintRepository.findAllByIsDeletedFalse();
        Map<Long, List<SprintFieldEntry>> sprintEntryMap = fieldEntryRepository.findAll()
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
        fieldEntryRepository.saveAll(sprintFieldEntries);
//
//        List<FieldObject> fieldObjectList = makeFieldObjectList(sprintFieldEntries);
//        SprintDetailResponseDto responseDto = new SprintDetailResponseDto(new_sprint, fieldObjectList, user);

        return getOneSprint(user, new_sprint.getId());
    }

    @Transactional
    public SuccessResponseEntity<SprintDetailResponseDto> getOneSprint(
            User user, Long sprintId
    ) {
        Sprint sprint = loadSprintById(sprintId);    //나중에 쿼리좀 다듬어서 리팩토링
        List<SprintFieldEntry> entries = fieldEntryRepository.findAllBySprintId(sprintId);
        List<FieldObject> fieldObjectList = makeFieldObjectList(entries);
        List<CommentResponseDto> comments = commentService.getCommentsOnSprint(sprintId, user);
        SprintDetailResponseDto responseDto = new SprintDetailResponseDto(sprint,fieldObjectList, user, comments);

        return new SuccessResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @Transactional
    public SuccessResponseEntity<SprintMessage> deleteSprint(
            User user, Long sprintId
    ) {
        Sprint sprint = loadSprintById(sprintId);
        if(!checkSprintOwner(sprint,user)){
            throw new UnAuthorizedRequestException("권한이 없습니다");
        }
        sprint.setDeleted(true);

        return new SuccessResponseEntity<>(new SprintMessage(MessageEnum.DELETED), HttpStatus.ACCEPTED);
    }

    @Transactional    ///리팩토링 필수;;
    public SuccessResponseEntity<SprintMessage> joinSprint(
            User user, Long sprintId, JoinSprintRequestDto requestDto
    ) {
        Sprint sprint = loadSprintById(sprintId);
        if(sprint.getUser().getId().equals(user.getId())){
            throw new MySprintException("내 스프린트에는 지원할 수 없습니다");
        }
        SprintFieldEntry field =
                fieldEntryRepository.findBySprintIdAndFieldName(sprintId, requestDto.getPosition())
                        .orElseThrow(() -> new FieldNotFoundException("포지션 정보를 찾을 수 없습니다."));
        if(joinEntryRepository.existsByUserIdAndSprintId(user.getId(), sprintId)){
            throw new AlreadyExistsException("이미 지원한 스프린트입니다");
        }
        if(field.getFieldMax() <= field.getFieldMemberCount()){
            throw new FieldAlreadyFullException("해당 포지션은 모집이 마감되었습니다");
        }
        SprintJoinEntry new_join = new SprintJoinEntry
                (user.getId(), sprintId, field.getFieldIdx(), requestDto.getGithubLink());

        joinEntryRepository.save(new_join);
        field.addFieldMember();

        return new SuccessResponseEntity<>(new SprintMessage(MessageEnum.JOINED), HttpStatus.OK);
    }

    public SuccessResponseEntity<SprintDetailResponseDto> updateSprint(
            User user, Long sprintId, SprintUpdateRequestDto requestDto
    ) {
        Sprint sprint = loadSprintById(sprintId);
        checkSprintOwner(sprint, user);
        sprint.setTitle(requestDto.getTitle());
        sprint.setContent(requestDto.getContent());
        List<SprintFieldEntry> entries = fieldEntryRepository.findAllBySprintId(sprintId);
        List<CommentResponseDto> comments = commentService.getCommentsOnSprint(sprintId, user);
        List<FieldObject> fieldObjectList = makeFieldObjectList(entries);

        SprintDetailResponseDto responseDto = new SprintDetailResponseDto(sprint,fieldObjectList, user, comments);

        return new SuccessResponseEntity<>(responseDto, HttpStatus.OK);
    }


    ////////////////내부 메소드들////////////////////////

    public Sprint loadSprintById(Long sprintId){
        Sprint sprint =  sprintRepository.findById(sprintId).orElseThrow(
                () -> new SprintNotFoundException("SprintId not found")
        );
        if(sprint.getIsDeleted()){
            throw new DeletedSprintException("삭제된 모임입니다");
        }
        return sprint;
    }

    private List<FieldObject> makeFieldObjectList(List<SprintFieldEntry> entries) {
        return entries.stream()
                .map(FieldObject::new)
                .collect(Collectors.toList());
    }

    private Boolean checkSprintOwner(Sprint sprint, User user){
        return sprint.getUser().getId().equals(user.getId());
    }
}
