package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Teacher;
import com.example.learningManagementSystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends BaseServiceImpl<Teacher> {
    public TeacherService(TeacherRepository teacherRepository) {
        super(teacherRepository);
    }
}
