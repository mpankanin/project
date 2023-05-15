package com.conference.project.model;

public class CustomerLoginExistsException extends RuntimeException{

    public CustomerLoginExistsException(String message){
        super(message);
    }

}
