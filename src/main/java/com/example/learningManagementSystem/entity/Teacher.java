package com.example.learningManagementSystem.entity;

import com.example.learningManagementSystem.service.UpdatableEntity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Teacher implements UpdatableEntity<Teacher> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    public Teacher() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getId() {
        return id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(unique = true, nullable = false, updatable = false)
    private String teacherNumber;

    @PrePersist
    public void generateTeacherNumber() {
        this.teacherNumber = "TCH-" +
                UUID.randomUUID().toString()
                        .substring(0, 8)
                        .toUpperCase();
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }
    @Override
    public void updateFrom(Teacher sourse) {
        this.firstName = sourse.getFirstName();
        this.lastName = sourse.getLastName();
    }
}
