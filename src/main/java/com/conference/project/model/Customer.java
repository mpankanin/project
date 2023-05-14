package com.conference.project.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String email;

    @OneToMany
    private Collection<Reservation> reservations = new ArrayList<>();


    public Customer() {
    }

    public Customer(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", reservations=" + reservations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id != null ? id.equals(customer.id) : customer.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
