package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Course;
import com.example.learningManagementSystem.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends BaseServiceImpl<Course> {
    public CourseService(CourseRepository courseRepository) {
        super(courseRepository);
    }
}
