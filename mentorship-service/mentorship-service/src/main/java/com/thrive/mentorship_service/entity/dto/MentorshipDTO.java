package com.thrive.mentorship_service.entity.dto;

import com.thrive.mentorship_service.entity.Mentor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class MentorshipDTO {


    @ManyToOne
    @JoinColumn(name = "mentorId", nullable = false)
    private Mentor mentor;

    private Date startDate;
    private Date endDate;

}
