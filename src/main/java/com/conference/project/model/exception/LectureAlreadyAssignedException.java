package com.conference.project.model.exception;


public class LectureAlreadyAssignedException extends RuntimeException{

    public LectureAlreadyAssignedException(String message) {
        super(message);
    }

    public LectureAlreadyAssignedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LectureAlreadyAssignedException(Throwable cause) {
        super(cause);
    }

}
