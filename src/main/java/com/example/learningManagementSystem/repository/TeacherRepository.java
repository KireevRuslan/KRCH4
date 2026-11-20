package com.example.learningManagementSystem.repository;

import com.example.learningManagementSystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
