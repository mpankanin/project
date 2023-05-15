package com.conference.project.controller;



import com.conference.project.model.Reservation;
import com.conference.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ReservationController {


    @Autowired
    ReservationRepository reservationRepository;












}
