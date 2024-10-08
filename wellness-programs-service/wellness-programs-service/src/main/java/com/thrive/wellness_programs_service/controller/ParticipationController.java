package com.thrive.wellness_programs_service.controller;

import com.thrive.wellness_programs_service.entity.dto.ParticipationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ParticipationController {

    public ResponseEntity<ParticipationDTO>joinActivity(@RequestBody ParticipationDTO participationDTO){
        return null;
    }

    public   ResponseEntity<ParticipationDTO>updateParticipationScore(@PathVariable Long userid , Long activityid, @RequestBody Long Score){
        return null;
    }

    public List<ResponseEntity<ParticipationDTO>>getParticipationsByUser(@PathVariable Long userid){
        return null;
    }
}



