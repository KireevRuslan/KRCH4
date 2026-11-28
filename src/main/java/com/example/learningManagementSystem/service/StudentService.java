package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Student;
import com.example.learningManagementSystem.exception.EntityNotFoundException;
import com.example.learningManagementSystem.repository.GroupRepository;
import com.example.learningManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.example.learningManagementSystem.exception.DuplicateEntityException;
import com.example.learningManagementSystem.entity.Group;

import java.util.List;

@Service
public class StudentService extends BaseServiceImpl<Student> {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public StudentService(GroupRepository groupRepository, StudentRepository studentRepository) {
        super(studentRepository);
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        validateGroups(student);
        resolveGroups(student);
        return super.create(student);
    }

    @Override
    public Student update(Long id, Student student) {
        validateGroups(student);
        resolveGroups(student);
        return super.update(id, student);
    }

    public Student getByStudentNumber(String studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    private void validateGroups(Student student) {
        if (student.getGroups() == null || student.getGroups().isEmpty()) {
            throw new DuplicateEntityException("student must belong to at least one group");
        }
    }

    private void resolveGroups(Student student){
        List<Long> groupIds = student.getGroups().stream()
                .map(Group::getId)
                .toList();
        List<Group> groups = groupRepository.findAllById(groupIds);
        if (groups.size() < groupIds.stream().distinct().count()) {
            throw new EntityNotFoundException("Group not found");
        }
        student.setGroups(groups);
    }


}
