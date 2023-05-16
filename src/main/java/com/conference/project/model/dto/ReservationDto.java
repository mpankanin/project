package com.conference.project.model.dto;

import com.conference.project.model.Reservation;

import java.util.Objects;

public class ReservationDto {

    private Long id;
    private CustomerDto customerDto;
    private LectureDto lectureDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public LectureDto getLectureDto() {
        return lectureDto;
    }

    public void setLectureDto(LectureDto lectureDto) {
        this.lectureDto = lectureDto;
    }

    public static ReservationDto from(Reservation reservation){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        if(Objects.nonNull(reservation.getCustomer()))
            reservationDto.setCustomerDto(CustomerDto.from(reservation.getCustomer()));
        if(Objects.nonNull(reservation.getLecture()))
            reservationDto.setLectureDto(LectureDto.from(reservation.getLecture()));
        return reservationDto;
    }
}
