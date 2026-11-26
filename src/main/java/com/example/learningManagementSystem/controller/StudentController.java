package com.example.learningManagementSystem.controller;

import com.example.learningManagementSystem.entity.Student;
import com.example.learningManagementSystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController extends BaseController<Student> {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        super(studentService);
        this.studentService = studentService;
    }
    @GetMapping("/number/{studentNumber}")
    public Student getByStudentNumber(@PathVariable String studentNumber) {
        return studentService.getByStudentNumber(studentNumber);
    }
}
