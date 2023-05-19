package com.conference.project.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "Lecture")
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String startDate;
    private String endDate;

    @OneToMany @JoinColumn(name = "lecture_id")
    private Collection<Reservation> reservations = new ArrayList<>();

    @ManyToOne
    private ThematicPath thematicPath;


    public Lecture() {
    }

    public Lecture(String title, String start, String end) {
        this.title = title;
        this.startDate = start;
        this.endDate = end;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public boolean isAvailable(){
        return reservations.size() < 5;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureId=" + id +
                ", title='" + title + '\'' +
                '}';
    }

}
