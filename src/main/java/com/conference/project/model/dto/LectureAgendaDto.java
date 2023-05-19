package com.conference.project.model.dto;

import com.conference.project.model.Lecture;


public class LectureAgendaDto {

    private Long id;
    private String title;
    private String start;
    private String end;
    private Integer vacancies;

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

    public Integer getVacancies() {
        return vacancies;
    }

    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
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

    public static LectureAgendaDto from(Lecture lecture){
        LectureAgendaDto lectureAgendaDto = new LectureAgendaDto();
        lectureAgendaDto.setId(lecture.getId());
        lectureAgendaDto.setTitle(lecture.getTitle());
        lectureAgendaDto.setStart(lecture.getStartDate());
        lectureAgendaDto.setEnd(lecture.getEndDate());
        lectureAgendaDto.setVacancies(5 - lecture.getReservations().size());
        return lectureAgendaDto;
    }

}
