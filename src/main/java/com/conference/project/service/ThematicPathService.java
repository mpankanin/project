package com.conference.project.service;

import com.conference.project.model.exception.LectureAlreadyAssignedException;
import com.conference.project.model.exception.ThematicPathNotFoundException;
import com.conference.project.model.Lecture;
import com.conference.project.model.ThematicPath;
import com.conference.project.repository.ThematicPathRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ThematicPathService {

    private final ThematicPathRepository thematicPathRepository;
    private final LectureService lectureService;

    public ThematicPathService(ThematicPathRepository thematicPathRepository, LectureService lectureService) {
        this.thematicPathRepository = thematicPathRepository;
        this.lectureService = lectureService;
    }

    public ThematicPath addThematicPath(ThematicPath thematicPath){
        return thematicPathRepository.save(thematicPath);
    }

    public List<ThematicPath> getThematicPaths(){
        return thematicPathRepository.findAll();
    }

    public ThematicPath getThematicPath(Long id){
        return thematicPathRepository.findById(id).orElseThrow(() -> new ThematicPathNotFoundException("Not found: " + id + " thematic path."));
    }

    public ThematicPath deleteThematicPath(Long id){
        ThematicPath thematicPath = getThematicPath(id);
        thematicPathRepository.delete(thematicPath);
        return thematicPath;
    }

    public ThematicPath editThematicPathDescription(Long id, String description){
        ThematicPath thematicPath = getThematicPath(id);
        thematicPath.setDescription(description);
        return thematicPath;
    }

    public ThematicPath addLectureToThematicPath(Long thematicPathId, Long lectureId){
        ThematicPath thematicPath = getThematicPath(thematicPathId);
        Lecture lecture = lectureService.getLecture(lectureId);
        if(Objects.nonNull(lecture.getThematicPath()))
            throw new LectureAlreadyAssignedException("Lecture: " + lectureId + " already assigned to: " + lecture.getThematicPath().getId() + " thematic path.");
        thematicPath.addLecture(lecture);
        lecture.setThematicPath(thematicPath);
        return thematicPath;
    }

    public ThematicPath removeLectureFromThematicPath(Long thematicPathId, Long lectureId){
        ThematicPath thematicPath = getThematicPath(thematicPathId);
        Lecture lecture = lectureService.getLecture(lectureId);
        thematicPath.removeLecture(lecture);
        return thematicPath;
    }





}
