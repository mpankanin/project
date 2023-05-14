package com.conference.project.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer lectureId;
    private String title;
    private Integer pathId;

    @OneToMany
    private Collection<Reservation> reservations = new ArrayList<>();


    public Lecture() {
    }

    public Lecture(String title, Integer pathId) {
        this.title = title;
        this.pathId = pathId;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPathId() {
        return pathId;
    }

    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureId=" + lectureId +
                ", title='" + title + '\'' +
                ", pathId=" + pathId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecture lecture = (Lecture) o;

        return lectureId != null ? lectureId.equals(lecture.lectureId) : lecture.lectureId == null;
    }

    @Override
    public int hashCode() {
        return lectureId != null ? lectureId.hashCode() : 0;
    }

}
