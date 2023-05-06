package com.example.sprintserver.sprint.dto;

import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.sprint.entity.SprintFieldEntry;
import com.example.sprintserver.sprint.enums.SprintTypeEnum;
import com.example.sprintserver.sprint.exception.InvalidParameterException;
import com.example.sprintserver.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
public class PostSprintRequestDto {
    private String title;
    private String content;
    private String sprintType;
    private List<FieldTupleDto> fieldsInfo;

    public PostSprintRequestDto(String title, String content, String sprintType, List<FieldTupleDto> fieldsInfo) {
        this.title = title;
        this.content = content;
        this.sprintType = sprintType;
        this.fieldsInfo = fieldsInfo;
    }

    public Sprint toSprintEntity(User user) {
        return Sprint.builder()
                .user(user)
                .sprintType(SprintTypeEnum.valueOf(this.sprintType.toUpperCase()))
                .title(this.title)
                .content(this.content)
                .build();
    }

    public List<SprintFieldEntry> toSprintFieldEntryList(Sprint sprint) {
        List<SprintFieldEntry> entries = new ArrayList<>();
        for(int i = 0; i<this.fieldsInfo.size(); i++){
            if(!fieldsInfo.get(i).getFieldMaxNum().equals(0)){
                SprintFieldEntry entry = toEntry(i+1, fieldsInfo.get(i), sprint);
                entries.add(entry);
            }
        }
        return entries;
    }

    private SprintFieldEntry toEntry(Integer fieldIdx, FieldTupleDto field, Sprint sprint){
        return SprintFieldEntry.builder()
                .fieldIdx(fieldIdx)
                .sprint(sprint)
                .fieldName(field.getFieldName())
                .fieldMax(field.getFieldMaxNum())
                .build();

    }
}
