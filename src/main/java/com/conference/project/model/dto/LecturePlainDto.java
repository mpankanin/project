package com.conference.project.model.dto;

import com.conference.project.model.Lecture;

public class LecturePlainDto {

    private Long id;
    private String title;
    private Long thematic_path_id;
    private String start;
    private String end;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getThematic_path_id() {
        return thematic_path_id;
    }

    public void setThematic_path_id(Long thematic_path_id) {
        this.thematic_path_id = thematic_path_id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public static LecturePlainDto from(Lecture lecture){
        LecturePlainDto lecturePlainDto = new LecturePlainDto();
        lecturePlainDto.setId(lecture.getId());
        lecturePlainDto.setTitle(lecture.getTitle());
        lecturePlainDto.setThematic_path_id(lecture.getThematicPath().getId());
        lecturePlainDto.setStart(lecture.getStartDate());
        lecturePlainDto.setEnd(lecture.getEndDate());
        return lecturePlainDto;
    }

}
