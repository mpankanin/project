package com.conference.project.controller;



import com.conference.project.service.ThematicPathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class ThematicPathController {

    private ThematicPathService thematicPathService;

    public ThematicPathController(ThematicPathService thematicPathService) {
        this.thematicPathService = thematicPathService;
    }


    @GetMapping("/conference-agenda")
    public ResponseEntity<String> getConferenceAgenda(){

        


        return null
    }



}
