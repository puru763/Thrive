package com.thrive.mentorship_service.controller;

import com.thrive.mentorship_service.entity.dto.MentorshipDTO;
import com.thrive.mentorship_service.service.MentorshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class MentorshipController {

   final MentorshipService mentorshipService;

    public MentorshipController(MentorshipService mentorshipService) {
        this.mentorshipService = mentorshipService;
    }



    public ResponseEntity<MentorshipDTO>createMentorship(@RequestBody MentorshipDTO mentorshipDTO){
        MentorshipDTO mentorship = mentorshipService.createMentorship(mentorshipDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(mentorship);
    }

    public ResponseEntity<List<MentorshipDTO>> getMentorshipsByMentor(@PathVariable Long id) {
        List<MentorshipDTO> mentorships = mentorshipService.getMentorshipsByMentor(id);
        return ResponseEntity.status(HttpStatus.OK).body(mentorships);
    }



}

