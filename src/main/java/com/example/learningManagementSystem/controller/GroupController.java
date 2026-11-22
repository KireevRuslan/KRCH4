package com.example.learningManagementSystem.controller;

import com.example.learningManagementSystem.entity.Group;
import com.example.learningManagementSystem.service.GroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
public class GroupController extends BaseController<Group> {
    public GroupController(GroupService groupService) {
        super(groupService);
    }
}
