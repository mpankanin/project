package com.conference.project.model.dto;

import com.conference.project.model.ThematicPath;

public class ThematicPathPlainDto {

    private Long id;
    private String description;

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

    public static ThematicPathPlainDto from(ThematicPath thematicPath){
        ThematicPathPlainDto thematicPathPlainDto = new ThematicPathPlainDto();
        thematicPathPlainDto.setId(thematicPath.getId());
        thematicPathPlainDto.setDescription(thematicPath.getDescription());
        return thematicPathPlainDto;
    }
}
