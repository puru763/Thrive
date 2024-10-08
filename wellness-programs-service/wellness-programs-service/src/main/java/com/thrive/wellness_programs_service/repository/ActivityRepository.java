package com.thrive.wellness_programs_service.repository;

import com.thrive.wellness_programs_service.entity.Activity;
import com.thrive.wellness_programs_service.entity.dto.ActivityDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ActivityRepository extends JpaRepository<Activity ,Long> {
    ActivityDTO addActivityToProgram(ActivityDTO activityDTO);
}
