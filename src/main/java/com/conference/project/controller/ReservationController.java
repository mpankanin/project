package com.conference.project.controller;


import com.conference.project.service.ReservationService;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

}
