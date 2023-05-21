package com.conference.project.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name = "ThematicPath")
public class ThematicPath {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    @OneToMany @JoinColumn(name = "thematic_path_id")
    private Collection<Lecture> lectures = new ArrayList<>();

    public ThematicPath() {
    }

    public ThematicPath(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void addLecture(Lecture lecture){
        lectures.add(lecture);
    }

    public void removeLecture(Lecture lecture){
        lectures.remove(lecture);
    }

    @Override
    public String toString() {
        return "ThematicPath{" +
                "pathId=" + id +
                ", description='" + description + '\'' +
                ", lectures=" + lectures +
                '}';
    }

}
