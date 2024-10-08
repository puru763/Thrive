package com.thrive.wellness_programs_service.entity.dto;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;


@Data
public class ParticipationDTO {
    private Long  activityId;

    private Long   userId;
    private  Integer score;
    private Instant completedAt;
}
