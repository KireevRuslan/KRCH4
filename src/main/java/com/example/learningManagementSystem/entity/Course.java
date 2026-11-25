package com.example.learningManagementSystem.entity;

import com.example.learningManagementSystem.service.UpdatableEntity;
import jakarta.persistence.*;

@Entity
public class Course implements UpdatableEntity<Course> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public void updateFrom(Course sourse) {
        this.name = sourse.getName();
    }
}
