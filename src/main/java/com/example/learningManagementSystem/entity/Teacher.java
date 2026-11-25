package com.example.learningManagementSystem.entity;

import com.example.learningManagementSystem.service.UpdatableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    @Override
    public void updateFrom(Teacher sourse) {
        this.firstName = sourse.getFirstName();
        this.lastName = sourse.getLastName();
    }
}
