package com.conference.project.model.dto;

import com.conference.project.model.Lecture;

public class LectureSummaryDto {

    private Long id;
    private String title;
    private String attendance;

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

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public static LectureSummaryDto from(Lecture lecture){
        LectureSummaryDto lectureSummaryDto = new LectureSummaryDto();
        lectureSummaryDto.setId(lecture.getId());
        lectureSummaryDto.setTitle(lecture.getTitle());
        lectureSummaryDto.setAttendance((lecture.getReservations().size()*20) + "%");
        return lectureSummaryDto;
    }

}
