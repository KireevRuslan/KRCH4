package com.example.learningManagementSystem.validator;

import com.example.learningManagementSystem.entity.Group;
import com.example.learningManagementSystem.exception.DuplicateEntityException;
import com.example.learningManagementSystem.repository.GroupRepository;
import org.springframework.stereotype.Component;

@Component
public class GroupDuplicateChecker implements DuplicateChecker<Group>{
    private final GroupRepository groupRepository;

    public GroupDuplicateChecker(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void check(Group group) {
        if (groupRepository.existsByName(group.getName())) {
            throw new DuplicateEntityException("Group already exists");
        }
    }

    @Override
    public void checkForUpdate(Group group, Long id) {
        if (groupRepository.existsByNameAndIdNot(group.getName(), id)) {
            throw new DuplicateEntityException("Group already exists");
        }
    }



}
