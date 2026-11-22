package com.example.learningManagementSystem.controller;

import com.example.learningManagementSystem.service.StudentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}
