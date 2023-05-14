package com.conference.project.controller;


import com.conference.project.model.Lecture;
import com.conference.project.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class LectureController {

    @Autowired
    private LectureRepository lectureRepository;


    @GetMapping("/lectures")
    public List<Lecture> getLectures(){
        return lectureRepository.findAll();
    }


}
