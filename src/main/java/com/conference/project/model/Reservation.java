package com.conference.project.model;

import jakarta.persistence.*;

@Entity
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer resId;
    private Integer customerId;
    private Integer lectureId;


    public Reservation() {
    }

    public Reservation(Integer customerId, Integer lectureId) {
        this.customerId = customerId;
        this.lectureId = lectureId;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "resId=" + resId +
                ", customerId=" + customerId +
                ", lectureId=" + lectureId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        return resId != null ? resId.equals(that.resId) : that.resId == null;
    }

    @Override
    public int hashCode() {
        return resId != null ? resId.hashCode() : 0;
    }

}
