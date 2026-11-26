package com.example.learningManagementSystem.controller;

import com.example.learningManagementSystem.entity.Teacher;
import com.example.learningManagementSystem.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeacherController extends BaseController<Teacher> {

    private final TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        super(teacherService);
        this.teacherService = teacherService;
    }

    @GetMapping("/number/{teacherNumber}")
    public Teacher getByTeacherNumber(@PathVariable String teacherNumber) {
        return teacherService.getByTeacherNumber(teacherNumber);
    }
}
