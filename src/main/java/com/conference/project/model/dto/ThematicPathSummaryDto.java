package com.conference.project.model.dto;

import com.conference.project.model.ThematicPath;

public class ThematicPathSummaryDto {

    private Long id;
    private String description;
    private String attendance;

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

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public static ThematicPathSummaryDto from(ThematicPath thematicPath){
        ThematicPathSummaryDto thematicPathPlainDto = new ThematicPathSummaryDto();
        thematicPathPlainDto.setId(thematicPath.getId());
        thematicPathPlainDto.setDescription(thematicPath.getDescription());
        thematicPathPlainDto.setAttendance((thematicPath.getLectures().stream().mapToInt(l -> l.getReservations().size()).sum()) * ((float)100/15) + "%");
        return thematicPathPlainDto;
    }
}
