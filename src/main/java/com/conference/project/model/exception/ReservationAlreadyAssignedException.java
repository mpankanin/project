package com.conference.project.model.exception;

public class ReservationAlreadyAssignedException extends RuntimeException{

    public ReservationAlreadyAssignedException(String message) {
        super(message);
    }

    public ReservationAlreadyAssignedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservationAlreadyAssignedException(Throwable cause) {
        super(cause);
    }
}
