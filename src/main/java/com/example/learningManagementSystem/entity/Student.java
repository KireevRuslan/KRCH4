package com.example.learningManagementSystem.entity;

import com.example.learningManagementSystem.service.UpdatableEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Student implements UpdatableEntity<Student> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;
    @ManyToMany
    @JoinTable(
            name = "student_group",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Group> groups;
    public Student() {

    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGroups(List<Group> groupList) {
        this.groups = groupList;
    }

    @Column(unique = true, nullable = false, updatable = false)
    private String studentNumber;

    @PrePersist
    public void generateStudentNumber() {
        this.studentNumber = "STU-" +
                UUID.randomUUID().toString()
                        .substring(0, 8)
                        .toUpperCase();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    @Override
    public void updateFrom(Student sourse) {
        this.firstName = sourse.getFirstName();
        this.lastName = sourse.getLastName();
    }
}
