package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Course;
import com.example.learningManagementSystem.repository.CourseRepository;
import com.example.learningManagementSystem.validator.CourseDuplicateChecker;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends BaseServiceImpl<Course> {
    private final CourseDuplicateChecker courseDuplicateChecker;

    @Override
    public Course create(Course course) {
        courseDuplicateChecker.check(course);
        return super.create(course);
    }

    @Override
    public Course update(Long id, Course course) {
        courseDuplicateChecker.checkForUpdate(course, id);
        return super.update(id, course);
    }


    public CourseService(CourseRepository courseRepository, CourseDuplicateChecker courseDuplicateChecker) {
        super(courseRepository);
        this.courseDuplicateChecker = courseDuplicateChecker;
    }


}
