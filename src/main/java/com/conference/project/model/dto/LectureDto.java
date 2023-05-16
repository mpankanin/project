package com.conference.project.model.dto;

import com.conference.project.model.Lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LectureDto {

    private Long id;
    private String title;
    private List<ReservationDto> reservationsDto = new ArrayList<>();
    private ThematicPathDto thematicPathDto;

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

    public List<ReservationDto> getReservationsDto() {
        return reservationsDto;
    }

    public void setReservationsDto(List<ReservationDto> reservationsDto) {
        this.reservationsDto = reservationsDto;
    }

    public ThematicPathDto getThematicPathDto() {
        return thematicPathDto;
    }

    public void setThematicPathDto(ThematicPathDto thematicPathDto) {
        this.thematicPathDto = thematicPathDto;
    }

    public static LectureDto from(Lecture lecture){
        LectureDto lectureDto = new LectureDto();
        lectureDto.setId(lecture.getId());
        lectureDto.setTitle(lecture.getTitle());
        lectureDto.setReservationsDto(lecture.getReservations().stream().map(ReservationDto::from).collect(Collectors.toList()));
        if(Objects.nonNull(lecture.getThematicPath()))
            lectureDto.setThematicPathDto(ThematicPathDto.from(lecture.getThematicPath()));
        return lectureDto;
    }

}
