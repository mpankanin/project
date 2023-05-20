package com.conference.project.service;

import com.conference.project.model.Lecture;
import com.conference.project.model.exception.ReservationNotFoundException;
import com.conference.project.model.Reservation;
import com.conference.project.repository.ReservationRepository;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

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

    public void sendEmailAdd(Lecture lecture, String email) throws IOException{
        String message = "Reservation successful: " + lecture.toString()
                + "\nDate of reservation: " + LocalDateTime.now()
                + "\nRecipient: " + email + "\n";

        Files.writeString(Paths.get("src/main/resources/email.txt"), message + System.lineSeparator(), CREATE, APPEND);
    }

    public void sendEmailCancel(Lecture lecture, String email) throws IOException{
        String message = "Reservation cancelled: " + lecture.toString()
                + "\nDate of cancellation: " + LocalDateTime.now()
                + "\nRecipient: " + email + "\n";

        Files.writeString(Paths.get("src/main/resources/email.txt"), message + System.lineSeparator(), CREATE, APPEND);
    }

}
