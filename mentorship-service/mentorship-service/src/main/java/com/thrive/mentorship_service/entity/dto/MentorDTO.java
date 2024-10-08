package com.thrive.mentorship_service.entity.dto;

import com.thrive.mentorship_service.entity.Mentorship;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class MentorDTO {

    private String name;
    private String expertise;

    private Long organizationId;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mentorship> mentorships = new ArrayList<>();
}
