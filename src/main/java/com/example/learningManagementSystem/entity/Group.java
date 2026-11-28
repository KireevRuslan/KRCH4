package com.example.learningManagementSystem.entity;

import com.example.learningManagementSystem.service.UpdatableEntity;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "study_groups")
public class Group implements UpdatableEntity<Group> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "groups")
    @JsonIgnore
    private List<Student> students;

    public Group() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<Student> studentList) {
        this.students = studentList;
    }

    @Override
    public void updateFrom(Group sourse) {
        this.name = sourse.getName();

    }
}
