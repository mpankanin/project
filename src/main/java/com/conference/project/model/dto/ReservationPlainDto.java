package com.conference.project.model.dto;

import com.conference.project.model.Reservation;

public class ReservationPlainDto {


    private Long id;
    private LecturePlainDto lecture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LecturePlainDto getLecture() {
        return lecture;
    }

    public void setLecture(LecturePlainDto lecture) {
        this.lecture = lecture;
    }

    public static ReservationPlainDto from(Reservation reservation){
        ReservationPlainDto reservationPlainDto = new ReservationPlainDto();
        reservationPlainDto.setId(reservation.getId());
        reservationPlainDto.setLecture(LecturePlainDto.from(reservation.getLecture()));
        return reservationPlainDto;
    }

}
