package com.conference.project.model.Exception;

public class ReservationNotFoundException extends RuntimeException{

    public ReservationNotFoundException(String message) {
        super(message);
    }

    public ReservationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservationNotFoundException(Throwable cause) {
        super(cause);
    }
}