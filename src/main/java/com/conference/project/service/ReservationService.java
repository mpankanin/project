package com.conference.project.service;

import com.conference.project.model.exception.ReservationNotFoundException;
import com.conference.project.model.Reservation;
import com.conference.project.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservations(){
        return reservationRepository.findAll();
    }

    public Reservation getReservation(Long id){
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Not found: " + id + " reservation."));
    }

    public Reservation deleteReservation(Long id){
        Reservation reservation = getReservation(id);
        reservationRepository.delete(reservation);
        return reservation;
    }

}
