package com.conference.project.model.exception;

public class ThematicPathNotFoundException extends RuntimeException{

    public ThematicPathNotFoundException(String message) {
        super(message);
    }

    public ThematicPathNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThematicPathNotFoundException(Throwable cause) {
        super(cause);
    }
}
