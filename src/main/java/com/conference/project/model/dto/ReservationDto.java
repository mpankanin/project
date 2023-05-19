package com.conference.project.model.dto;

import com.conference.project.model.Reservation;

import java.util.Objects;

public class ReservationDto {

    private Long reservation_id;
    private CustomerPlainDto customer;
    private LecturePlainDto lecture;

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public CustomerPlainDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerPlainDto customer) {
        this.customer = customer;
    }

    public LecturePlainDto getLecture() {
        return lecture;
    }

    public void setLecture(LecturePlainDto lecture) {
        this.lecture = lecture;
    }

    public static ReservationDto from(Reservation reservation){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setReservation_id(reservation.getId());
        if(Objects.nonNull(reservation.getCustomer()))
            reservationDto.setCustomer(CustomerPlainDto.from(reservation.getCustomer()));
        if(Objects.nonNull(reservation.getLecture()))
            reservationDto.setLecture(LecturePlainDto.from(reservation.getLecture()));
        return reservationDto;
    }
}
