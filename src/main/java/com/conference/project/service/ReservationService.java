package com.conference.project.service;

import com.conference.project.model.Lecture;
import com.conference.project.model.exception.ReservationNotFoundException;
import com.conference.project.model.Reservation;
import com.conference.project.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
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

    public void sendEmail(Lecture lecture, String email) throws IOException{
        String message = "Reservation successful: " + lecture.toString()
                + "\nDate of reservation: " + LocalDateTime.now()
                + "\nRecipient: " + email + "\n";

        File toSend = new File("src/main/resources/email.txt");
        Files.writeString(toSend.toPath(), message);
    }

}
