package com.thrive.mentorship_service.service;

import com.thrive.mentorship_service.entity.dto.MentorshipDTO;

import java.util.List;

public interface MentorshipService {
    MentorshipDTO createMentorship(MentorshipDTO mentorshipDTO);

    List<MentorshipDTO> getMentorshipsByMentor(Long id);
}
