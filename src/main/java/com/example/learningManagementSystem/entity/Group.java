package com.example.learningManagementSystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "study_groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "groups")
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
}
