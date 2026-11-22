package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Schedule;
import com.example.learningManagementSystem.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService extends BaseServiceImpl<Schedule> {
    public ScheduleService(ScheduleRepository scheduleRepository) {
        super(scheduleRepository);
    }
}
