package com.conference.project.model.dto;

import com.conference.project.model.ThematicPath;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThematicPathDto {

    private Long id;
    private String description;
    private List<LectureAgendaDto> lectures = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LectureAgendaDto> getLectures() {
        return lectures;
    }

    public void setLectures(List<LectureAgendaDto> lectures) {
        this.lectures = lectures;
    }

    public static ThematicPathDto from(ThematicPath thematicPath){
        ThematicPathDto thematicPathDto = new ThematicPathDto();
        thematicPathDto.setId(thematicPath.getId());
        thematicPathDto.setDescription(thematicPath.getDescription());
        thematicPathDto.setLectures(thematicPath.getLectures().stream().map(LectureAgendaDto::from).collect(Collectors.toList()));
        return thematicPathDto;
    }
}
