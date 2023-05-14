package com.conference.project.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer id) {
        this.customerId = id;
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
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

        return customerId != null ? customerId.equals(customer.customerId) : customer.customerId == null;
    }

    @Override
    public int hashCode() {
        return customerId != null ? customerId.hashCode() : 0;
    }

}
