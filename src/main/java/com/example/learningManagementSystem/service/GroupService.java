package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Group;
import com.example.learningManagementSystem.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends BaseServiceImpl<Group> {

    public GroupService(GroupRepository groupRepository) {
        super(groupRepository);
    }
}
