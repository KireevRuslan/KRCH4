package com.example.learningManagementSystem.entity;

import com.example.learningManagementSystem.service.UpdatableEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Schedule implements UpdatableEntity<Schedule> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    public Schedule() {

    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Course getCourse() {
        return course;
    }

    public Group getGroup() {
        return group;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    @Override
    public void updateFrom(Schedule sourse) {
        this.startDateTime = sourse.getStartDateTime();
        this.endDateTime = sourse.getEndDateTime();
    }
}

