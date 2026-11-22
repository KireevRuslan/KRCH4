package com.example.learningManagementSystem.controller;

import com.example.learningManagementSystem.entity.Student;
import com.example.learningManagementSystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController extends BaseController<Student> {
    public StudentController(StudentService studentService) {
        super(studentService);
    }
}
