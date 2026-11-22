package com.example.learningManagementSystem.controller;

import com.example.learningManagementSystem.entity.Teacher;
import com.example.learningManagementSystem.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeacherController extends BaseController<Teacher> {
    public TeacherController(TeacherService teacherService) {
        super(teacherService);
    }
}
