package com.conference.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne //@JsonBackReference
    private Customer customer;
    @ManyToOne //@JsonBackReference
    private Lecture lecture;

    public Reservation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer resId) {
        this.id = resId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "resId=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
