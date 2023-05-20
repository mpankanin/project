package com.conference.project.controller;



import com.conference.project.model.ThematicPath;
import com.conference.project.model.dto.ThematicPathDto;
import com.conference.project.model.dto.ThematicPathSummaryDto;
import com.conference.project.service.ThematicPathService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ThematicPathController {

    private final ThematicPathService thematicPathService;


    public ThematicPathController(ThematicPathService thematicPathService) {
        this.thematicPathService = thematicPathService;
    }

    @GetMapping("/agenda")
    public ResponseEntity<List<ThematicPathDto>> getAgenda(){
        List<ThematicPath> pathList = thematicPathService.getThematicPaths();
        return new ResponseEntity<>(pathList.stream().map(ThematicPathDto::from).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/paths/summary")
    public ResponseEntity<List<ThematicPathSummaryDto>> getSummaryPaths(){
        List<ThematicPath> pathList = thematicPathService.getThematicPaths();
        return new ResponseEntity<>(pathList.stream().map(ThematicPathSummaryDto::from).collect(Collectors.toList()), HttpStatus.OK);
    }



}
