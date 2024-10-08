package com.thrive.mentorship_service.service;

import com.thrive.mentorship_service.entity.dto.MentorDTO;

import java.util.List;

public interface MentorService {
    MentorDTO createMentor(MentorDTO mentorDTO);

    List<MentorDTO> getMentorsByOrganization(Long id);
}
