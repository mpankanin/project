package com.conference.project.controller;


import com.conference.project.model.Customer;
import com.conference.project.model.Lecture;
import com.conference.project.model.Reservation;
import com.conference.project.model.dto.ReservationDto;
import com.conference.project.model.exception.CustomerAlreadyAssignedException;
import com.conference.project.model.exception.LectureAlreadyAssignedException;
import com.conference.project.service.CustomerService;
import com.conference.project.service.LectureService;
import com.conference.project.service.ReservationService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final CustomerService customerService;
    private final LectureService lectureService;

    public ReservationController(ReservationService reservationService, CustomerService customerService, LectureService lectureService) {
        this.reservationService = reservationService;
        this.customerService = customerService;
        this.lectureService = lectureService;
    }

    @PostMapping(value = "{lectureId}")
    public ResponseEntity<ReservationDto> addReservation(@PathVariable Long lectureId, @RequestBody Customer customer){
        System.out.println("----LINE 1----");
        if(!lectureService.lectureIsAvailable(lectureId))
            throw new LectureAlreadyAssignedException("Lecture is fully booked");
        System.out.println("----LINE 2----");

        Lecture lecture = lectureService.getLecture(lectureId);
        Reservation reservation;
        Customer theCustomer;
        Optional<Customer> optional = customerService.getCustomers()
                .stream()
                .filter(c -> c.getLogin().equals(customer.getLogin()))
                .filter(c -> c.getEmail().equals(customer.getEmail()))
                .findFirst();

        System.out.println("----LINE 3----");
        if(optional.isEmpty()){
            optional = customerService.getCustomers()
                    .stream()
                    .filter(c -> c.getLogin().equals(customer.getLogin()))
                    .findFirst();

            System.out.println("----LINE 4----");
            if(optional.isPresent())
                throw new CustomerAlreadyAssignedException("Login already exists");
        }

        System.out.println("----LINE 5----");
        if(optional.isEmpty()){
            theCustomer = customerService.addCustomer(customer);
        }else
            theCustomer = customerService.getCustomer(optional.get().getId());

        System.out.println("----LINE 6----");
        System.out.println(theCustomer);
        System.out.println(lecture);
        reservation = new Reservation(theCustomer, lecture);
        System.out.println(reservation);
        reservationService.addReservation(reservation);
        return new ResponseEntity<>(ReservationDto.from(reservation), HttpStatus.OK);
    }




}
