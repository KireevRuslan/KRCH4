package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Student;
import com.example.learningManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
    }
}
