package com.conference.project.controller;


import com.conference.project.model.Lecture;
import com.conference.project.model.dto.LecturePlainDto;
import com.conference.project.model.dto.LectureSummaryDto;
import com.conference.project.service.LectureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping
    public ResponseEntity<List<LecturePlainDto>> getLectures(){
        List<Lecture> lectures = lectureService.getLectures();
        List<LecturePlainDto> lecturesPlainDto = lectures.stream().map(LecturePlainDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(lecturesPlainDto, HttpStatus.OK);
    }

    @GetMapping("/summary")
    public ResponseEntity<List<LectureSummaryDto>> getSummaryLectures(){
        List<Lecture> lectureList = lectureService.getLectures();
        return new ResponseEntity<>(lectureList.stream().map(LectureSummaryDto::from).collect(Collectors.toList()), HttpStatus.OK);
    }

}
