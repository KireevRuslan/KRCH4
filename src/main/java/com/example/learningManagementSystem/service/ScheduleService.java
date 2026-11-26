package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Schedule;
import com.example.learningManagementSystem.repository.ScheduleRepository;
import com.example.learningManagementSystem.validator.ScheduleDuplicateChecker;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService extends BaseServiceImpl<Schedule> {
    private final ScheduleDuplicateChecker scheduleDuplicateChecker;

    public ScheduleService(ScheduleRepository scheduleRepository, ScheduleDuplicateChecker scheduleDuplicateChecker) {
        super(scheduleRepository);
        this.scheduleDuplicateChecker = scheduleDuplicateChecker;
    }

    @Override
    public Schedule create(Schedule entity) {
        scheduleDuplicateChecker.check(entity);
        return super.create(entity);
    }

    @Override
    public Schedule update(Long id, Schedule entity) {
        scheduleDuplicateChecker.checkForUpdate(entity, id);
        return super.update(id, entity);
    }
}
