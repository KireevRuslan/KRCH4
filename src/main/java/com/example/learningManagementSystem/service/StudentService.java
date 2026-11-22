package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Student;
import com.example.learningManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent){
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("student not found"));
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        return studentRepository.save(student);
    }

    public Student deleteStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not foud"));
        studentRepository.delete(student);
        return student;
    }
}
