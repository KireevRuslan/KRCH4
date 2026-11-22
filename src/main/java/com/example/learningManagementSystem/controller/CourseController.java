package com.example.learningManagementSystem.controller;

import com.example.learningManagementSystem.entity.Course;
import com.example.learningManagementSystem.service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController extends BaseController<Course> {
    public CourseController(CourseService courseService) {
        super(courseService);
    }
}
