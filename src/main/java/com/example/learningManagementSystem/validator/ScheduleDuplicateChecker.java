package com.example.learningManagementSystem.validator;

import com.example.learningManagementSystem.entity.Schedule;
import com.example.learningManagementSystem.exception.DuplicateEntityException;
import com.example.learningManagementSystem.repository.ScheduleRepository;
import org.springframework.stereotype.Component;

@Component
public class ScheduleDuplicateChecker implements DuplicateChecker<Schedule> {
    private final ScheduleRepository scheduleRepository;

    public ScheduleDuplicateChecker(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    @Override
    public void check(Schedule entity) {

        if (!entity.getStartDateTime().isBefore(entity.getEndDateTime())) {
            throw new DuplicateEntityException("Invalid schedule time");
        }

        if (scheduleRepository.existsByTeacherIdAndStartDateTimeBeforeAndEndDateTimeAfter(
                entity.getTeacher().getId(),
                entity.getEndDateTime(),
                entity.getStartDateTime()
        )) {
            throw new DuplicateEntityException("Teacher already has a lesson at this time");
        }
        if (scheduleRepository.existsByGroupIdAndStartDateTimeBeforeAndEndDateTimeAfter(
                entity.getGroup().getId(),
                entity.getEndDateTime(),
                entity.getStartDateTime()
        )) {
            throw new DuplicateEntityException("Group already has a lesson at this time");
        }
    }

    @Override
    public void checkForUpdate(Schedule entity, Long id) {
        if (!entity.getStartDateTime().isBefore(entity.getEndDateTime())) {
            throw new DuplicateEntityException("Invalid schedule time");
        }
        if (scheduleRepository.existsByTeacherIdAndStartDateTimeBeforeAndEndDateTimeAfterAndIdNot(
                entity.getTeacher().getId(),
                entity.getEndDateTime(),
                entity.getStartDateTime(),
                id
        )) {
            throw new DuplicateEntityException("Teacher already has a lesson at this time");
        }
        if (scheduleRepository.existsByGroupIdAndStartDateTimeBeforeAndEndDateTimeAfterAndIdNot(
                entity.getGroup().getId(),
                entity.getEndDateTime(),
                entity.getStartDateTime(),
                id
        )) {
            throw new DuplicateEntityException("Group already has a lesson at this time");
        }
    }
}
