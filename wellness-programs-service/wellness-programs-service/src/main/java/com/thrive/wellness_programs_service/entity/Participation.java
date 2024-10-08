package com.thrive.wellness_programs_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;
@Entity
@Data
@Table(name = "participation")
public class Participation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "wellness_program_id")
    private WellnessProgram wellnessProgram;


    private Long userId;
    private  Integer score;
    private Instant completedAt;




}
