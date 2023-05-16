package com.conference.project.model.Exception;

public class LectureNotFoundException extends RuntimeException{

    public LectureNotFoundException(String message) {
        super(message);
    }

    public LectureNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LectureNotFoundException(Throwable cause) {
        super(cause);
    }
}
