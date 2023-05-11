package com.example.sprintserver.sprint.dto;

import com.example.sprintserver.sprint.entity.Sprint;
import com.example.sprintserver.sprint.entity.SprintFieldEntry;
import com.example.sprintserver.sprint.enums.SprintTypeEnum;
import com.example.sprintserver.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
public class PostSprintRequestDto {
    private String title;
    private String content;
    private String sprintType;
    @NotNull
    private List<FieldTupleDto> fieldInfoList;

    public PostSprintRequestDto(String title, String content, String sprintType, List<FieldTupleDto> fieldInfoList) {
        this.title = title;
        this.content = content;
        this.sprintType = sprintType;
        this.fieldInfoList = fieldInfoList;
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
        for(int i = 0; i<this.fieldInfoList.size(); i++){
            if(!fieldInfoList.get(i).getFieldMaxNum().equals(0)){
                SprintFieldEntry entry = toSprintFieldEntry(i+1, fieldInfoList.get(i), sprint);
                entries.add(entry);
            }
        }
        return entries;
    }

    private SprintFieldEntry toSprintFieldEntry(Integer fieldIdx, FieldTupleDto field, Sprint sprint){
        return SprintFieldEntry.builder()
                .fieldIdx(fieldIdx)
                .sprint(sprint)
                .fieldName(field.getFieldName())
                .fieldMax(field.getFieldMaxNum())
                .build();

    }
}
