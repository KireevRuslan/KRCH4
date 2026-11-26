package com.example.learningManagementSystem.validator;

import com.example.learningManagementSystem.entity.Course;
import com.example.learningManagementSystem.exception.DuplicateEntityException;
import com.example.learningManagementSystem.repository.CourseRepository;
import org.springframework.stereotype.Component;

@Component
public class CourseDuplicateChecker implements DuplicateChecker<Course> {
    private final CourseRepository courseRepository;

    public CourseDuplicateChecker(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public void check(Course course) {
        if (courseRepository.existsByName(course.getName())) {
            throw new DuplicateEntityException("Course already exists");
        }
    }

    @Override
    public void checkForUpdate(Course course, Long id) {
        if (courseRepository.existsByNameAndIdNot(course.getName(), id)) {
            throw new DuplicateEntityException("Course already exist");
        }
    }
}
