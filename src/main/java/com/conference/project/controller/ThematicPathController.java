package com.conference.project.controller;


import com.conference.project.model.ThematicPath;
import com.conference.project.repository.ThematicPathRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThematicPathController {

    private final ThematicPathRepository thematicPathRepository;

    public ThematicPathController(ThematicPathRepository thematicPathRepository) {
        this.thematicPathRepository = thematicPathRepository;
    }

    @GetMapping("/thematic-paths")
    public List<ThematicPath> getThematicPaths(){
        return thematicPathRepository.findAll();
    }





}
