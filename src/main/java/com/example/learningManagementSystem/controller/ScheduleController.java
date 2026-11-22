package com.example.learningManagementSystem.controller;

import com.example.learningManagementSystem.entity.Schedule;
import com.example.learningManagementSystem.service.ScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
public class ScheduleController extends BaseController<Schedule> {
    public ScheduleController(ScheduleService scheduleService) {
        super(scheduleService);
    }
}
