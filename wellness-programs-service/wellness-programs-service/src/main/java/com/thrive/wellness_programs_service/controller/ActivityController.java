package com.thrive.wellness_programs_service.controller;

import com.thrive.wellness_programs_service.entity.dto.ActivityDTO;
import com.thrive.wellness_programs_service.repository.ActivityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class ActivityController {

    final ActivityRepository activityRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public ResponseEntity<ActivityDTO> addActivityToProgram(@RequestBody ActivityDTO activityDTO){
        ActivityDTO activity =   activityRepository.addActivityToProgram(activityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(activity);
    }
}
