package com.example.learningManagementSystem.repository;

import com.example.learningManagementSystem.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
