package com.conference.project.controller;


import com.conference.project.model.Customer;
import com.conference.project.model.Lecture;
import com.conference.project.model.Reservation;
import com.conference.project.model.dto.ReservationDto;
import com.conference.project.model.dto.ReservationPlainDto;
import com.conference.project.model.exception.CustomerAlreadyAssignedException;
import com.conference.project.model.exception.LectureAlreadyAssignedException;
import com.conference.project.model.exception.ReservationNotFoundException;
import com.conference.project.service.CustomerService;
import com.conference.project.service.LectureService;
import com.conference.project.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


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

    @PostMapping("/{lectureId}")
    public ResponseEntity<ReservationPlainDto> addReservation(@PathVariable Long lectureId, @RequestBody Customer customer){

        Lecture lecture = lectureService.getLecture(lectureId);

        if(!lecture.isAvailable())
            throw new LectureAlreadyAssignedException("Lecture is fully booked");

        Reservation reservation;
        Customer theCustomer;

        Optional<Customer> optional = customerService.getCustomers()
                .stream()
                .filter(c -> c.getLogin().equals(customer.getLogin()))
                .filter(c -> c.getEmail().equals(customer.getEmail()))
                .findFirst();

        if(optional.isEmpty()){
            optional = customerService.getCustomers()                                //check if provided customer login is correct
                    .stream()
                    .filter(c -> c.getLogin().equals(customer.getLogin()))
                    .findFirst();

            if(optional.isPresent())
                throw new CustomerAlreadyAssignedException("Login already exists");

            theCustomer = customerService.addCustomer(customer);
        }else
            theCustomer = customerService.getCustomer(optional.get().getId());

        if(theCustomer.getReservations().stream().anyMatch(r -> Objects.equals(r.getLecture().getStartDate(), lecture.getStartDate())))
            throw new CustomerAlreadyAssignedException("Customer can be signed only for one lecture in the same time");

        reservation = reservationService.addReservation(new Reservation(theCustomer, lecture));

        try {
            reservationService.sendEmailAdd(lecture, theCustomer.getEmail());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(ReservationPlainDto.from(reservation), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getReservations(){
        List<Reservation> reservationList = reservationService.getReservations();
        List<ReservationDto> reservationsDto = reservationList.stream().map(ReservationDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(reservationsDto, HttpStatus.OK);
    }

    @GetMapping("/{login}")
    public ResponseEntity<List<ReservationPlainDto>> getCustomerReservations(@PathVariable String login){
        Customer customer = customerService.getCustomer(login);
        return new ResponseEntity<>(customer.getReservations().stream().map(ReservationPlainDto::from).collect(Collectors.toList()), HttpStatus.OK);
    }

    @DeleteMapping("{login}/{resId}")
    public ResponseEntity<ReservationPlainDto> deleteReservation(@PathVariable String login, @PathVariable Long resId){
        Customer customer = customerService.getCustomer(login);
        Reservation reservation = reservationService.getReservation(resId);
        if(!reservation.getCustomer().getId().equals(customer.getId()))
            throw new ReservationNotFoundException("Customer doesn't have reservation matching provided data");

        try {
            reservationService.sendEmailCancel(reservation.getLecture(), customer.getEmail());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(ReservationPlainDto.from(reservationService.deleteReservation(resId)), HttpStatus.OK);
    }

}
