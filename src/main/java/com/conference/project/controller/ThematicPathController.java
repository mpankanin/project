package com.conference.project.controller;


import com.conference.project.model.ThematicPath;
import com.conference.project.repository.ThematicPathRepository;
import com.conference.project.service.ThematicPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ThematicPathController {

    private ThematicPathService thematicPathService;

    public ThematicPathController(ThematicPathService thematicPathService) {
        this.thematicPathService = thematicPathService;
    }



}
