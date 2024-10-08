package com.thrive.mentorship_service.controller;

import com.thrive.mentorship_service.entity.dto.MentorDTO;
import com.thrive.mentorship_service.service.MentorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class MentorController {


    final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    public ResponseEntity<MentorDTO> createMentor(@RequestBody MentorDTO mentorDTO){
        MentorDTO  mentor =  mentorService.createMentor(mentorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mentor);
    }

    public ResponseEntity<List<MentorDTO>> getMentorsByOrganization(@PathVariable Long id){
       List<MentorDTO> mentors = mentorService.getMentorsByOrganization(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(mentors);

    }
}
