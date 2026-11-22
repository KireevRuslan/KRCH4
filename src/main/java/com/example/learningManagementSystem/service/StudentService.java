package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Student;
import com.example.learningManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseServiceImpl<Student> {

    public StudentService(StudentRepository studentRepository) {
        super(studentRepository);
    }


}
