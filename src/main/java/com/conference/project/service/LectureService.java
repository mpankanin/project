package com.conference.project.service;

import com.conference.project.model.exception.LectureNotFoundException;
import com.conference.project.model.exception.ReservationAlreadyAssignedException;
import com.conference.project.model.Lecture;
import com.conference.project.model.Reservation;
import com.conference.project.repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LectureService {

    private final LectureRepository lectureRepository;
    private final ReservationService reservationService;

    public LectureService(LectureRepository lectureRepository, ReservationService reservationService) {
        this.lectureRepository = lectureRepository;
        this.reservationService = reservationService;
    }

    public Lecture addLecture(Lecture lecture){
        return lectureRepository.save(lecture);
    }

    public List<Lecture> getLectures(){
        return lectureRepository.findAll();
    }

    public Lecture getLecture(Long id){
        return lectureRepository.findById(id).orElseThrow(() -> new LectureNotFoundException("Not found: " + id + " lecture."));
    }

    public Lecture deleteLecture(Long id){
        Lecture lecture = getLecture(id);
        lectureRepository.delete(lecture);
        return lecture;
    }

    public Lecture editLectureTitle(Long id, String title){
        Lecture lecture = getLecture(id);
        lecture.setTitle(title);
        return lecture;
    }

    public Lecture addReservationToLecture(Long lectureId, Long reservationId){
        Lecture lecture = getLecture(lectureId);
        Reservation reservation = reservationService.getReservation(reservationId);
        if(Objects.nonNull(reservation.getLecture()))
            throw new ReservationAlreadyAssignedException("Reservation: " + reservationId + " already assigned to: " + reservation.getLecture().getId() + " lecture.");
        lecture.addReservation(reservation);
        reservation.setLecture(lecture);
        return lecture;
    }

    public Lecture removeReservationFromLecture(Long lectureId, Long reservationId){
        Lecture lecture = getLecture(lectureId);
        Reservation reservation = reservationService.getReservation(reservationId);
        lecture.removeReservation(reservation);
        return lecture;
    }

    public boolean lectureIsAvailable(Long lectureId){
        Lecture lecture = lectureRepository
                .findById(lectureId)
                .orElseThrow(()-> new LectureNotFoundException("Invalid id number"));
        return lecture.getReservations().size() < 5;
    }

}
