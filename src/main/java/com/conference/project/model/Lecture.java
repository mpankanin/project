package com.conference.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;

    @OneToMany(mappedBy = "lecture") @JsonManagedReference
    private Collection<Reservation> reservations = new ArrayList<>();

    @ManyToOne @JsonBackReference
    private ThematicPath thematicPath;


    public Lecture() {
    }

    public Lecture(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer lectureId) {
        this.id = lectureId;
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

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureId=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecture lecture = (Lecture) o;

        return id != null ? id.equals(lecture.id) : lecture.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
