package com.conference.project.model;


import com.conference.project.model.dto.CustomerPlainDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name = "Customer")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String email;

    @OneToMany @JoinColumn(name = "customer_id")
    private Collection<Reservation> reservations = new ArrayList<>();


    public Customer(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation){
        reservations.remove(reservation);
    }

    public static Customer from(CustomerPlainDto customerPlainDto){
        Customer customer = new Customer();
        customer.setLogin(customerPlainDto.getLogin());
        customer.setEmail(customerPlainDto.getEmail());
        return customer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", reservations=" + reservations +
                '}';
    }

}
