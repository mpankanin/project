package com.conference.project.model.Exception;

public class CustomerAlreadyAssignedException extends RuntimeException{

    public CustomerAlreadyAssignedException(String message) {
        super(message);
    }

    public CustomerAlreadyAssignedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerAlreadyAssignedException(Throwable cause) {
        super(cause);
    }
}
