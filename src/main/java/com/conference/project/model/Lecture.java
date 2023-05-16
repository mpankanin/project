package com.conference.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Lecture")
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @OneToMany @JoinColumn(name = "lecture_id")
    private Collection<Reservation> reservations = new ArrayList<>();

    @ManyToOne
    private ThematicPath thematicPath;


    public Lecture() {
    }

    public Lecture(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    public ThematicPath getThematicPath() {
        return thematicPath;
    }

    public void setThematicPath(ThematicPath thematicPath) {
        this.thematicPath = thematicPath;
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation){
        reservations.remove(reservation);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureId=" + id +
                ", title='" + title + '\'' +
                '}';
    }

}
