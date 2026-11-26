package com.example.learningManagementSystem.repository;

import com.example.learningManagementSystem.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    boolean existsByTeacherIdAndStartDateTimeBeforeAndEndDateTimeAfterAndIdNot(
            Long teacherId,
            LocalDateTime newEnd,
            LocalDateTime newStart,
            Long id
    );
    boolean existsByGroupIdAndStartDateTimeBeforeAndEndDateTimeAfterAndIdNot(
            Long groupId,
            LocalDateTime newEnd,
            LocalDateTime newStart,
            Long id
    );
    boolean existsByTeacherIdAndStartDateTimeBeforeAndEndDateTimeAfter(
            Long teacherId,
            LocalDateTime newEnd,
            LocalDateTime newStart
    );

    boolean existsByGroupIdAndStartDateTimeBeforeAndEndDateTimeAfter(
            Long groupId,
            LocalDateTime newEnd,
            LocalDateTime newStart
    );

}
