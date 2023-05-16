package com.conference.project.model.dto;

import com.conference.project.model.ThematicPath;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThematicPathDto {

    private Long id;
    private String description;
    private List<LectureDto> lecturesDto = new ArrayList<>();

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

    public List<LectureDto> getLecturesDto() {
        return lecturesDto;
    }

    public void setLecturesDto(List<LectureDto> lecturesDto) {
        this.lecturesDto = lecturesDto;
    }

    public static ThematicPathDto from(ThematicPath thematicPath){
        ThematicPathDto thematicPathDto = new ThematicPathDto();
        thematicPathDto.setId(thematicPath.getId());
        thematicPathDto.setDescription(thematicPath.getDescription());
        thematicPathDto.setLecturesDto(thematicPath.getLectures().stream().map(LectureDto::from).collect(Collectors.toList()));
        return thematicPathDto;
    }
}
