package com.conference.project.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ThematicPath {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pathId;
    private String description;

    @OneToMany
    private Collection<Lecture> lectures = new ArrayList<>();


    public ThematicPath() {
    }

    public ThematicPath(String description) {
        this.description = description;
    }

    public Integer getPathId() {
        return pathId;
    }

    public void setPathId(Integer id) {
        this.pathId = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ThematicPath{" +
                "pathId=" + pathId +
                ", description='" + description + '\'' +
                ", lectures=" + lectures +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThematicPath that = (ThematicPath) o;

        return pathId != null ? pathId.equals(that.pathId) : that.pathId == null;
    }

    @Override
    public int hashCode() {
        return pathId != null ? pathId.hashCode() : 0;
    }

}
