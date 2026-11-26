package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Student;
import com.example.learningManagementSystem.exception.EntityNotFoundException;
import com.example.learningManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseServiceImpl<Student> {

    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        super(studentRepository);
        this.studentRepository = studentRepository;
    }

    public Student getByStudentNumber(String studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }
}
