package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Group;
import com.example.learningManagementSystem.repository.GroupRepository;
import com.example.learningManagementSystem.validator.GroupDuplicateChecker;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends BaseServiceImpl<Group> {
    private final GroupDuplicateChecker groupDuplicateChecker;

    @Override
    public Group create(Group group) {
        groupDuplicateChecker.check(group);
        return super.create(group);
    }

    @Override
    public Group update(Long id, Group group) {
        groupDuplicateChecker.checkForUpdate(group, id);
        return super.update(id, group);
    }

    public GroupService(GroupRepository groupRepository, GroupDuplicateChecker groupDuplicateChecker) {
        super(groupRepository);
        this.groupDuplicateChecker = groupDuplicateChecker;
    }
}
