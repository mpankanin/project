package com.conference.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ThematicPath {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;

    @OneToMany(mappedBy = "thematicPath") @JsonIgnore//@JsonManagedReference
    private Collection<Lecture> lectures = new ArrayList<>();


    public ThematicPath() {
    }

    public ThematicPath(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Collection<Lecture> lectures) {
        this.lectures = lectures;
    }

    @Override
    public String toString() {
        return "ThematicPath{" +
                "pathId=" + id +
                ", description='" + description + '\'' +
                ", lectures=" + lectures +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThematicPath that = (ThematicPath) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
