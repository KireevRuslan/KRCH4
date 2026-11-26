package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Teacher;
import com.example.learningManagementSystem.exception.EntityNotFoundException;
import com.example.learningManagementSystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends BaseServiceImpl<Teacher> {
    private final TeacherRepository teacherRepository;
    public TeacherService(TeacherRepository teacherRepository) {
        super(teacherRepository);
        this.teacherRepository = teacherRepository;
    }

    public Teacher getByTeacherNumber(String teacherNumber){
        return teacherRepository.findByTeacherNumber(teacherNumber).orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
    }
}
