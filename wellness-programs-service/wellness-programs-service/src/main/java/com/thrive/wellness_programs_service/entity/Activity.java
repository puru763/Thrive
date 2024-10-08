package com.thrive.wellness_programs_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wellnessProgramid", nullable = false)
    private WellnessProgram wellnessProgram;

    private String name;
    private String description;
    private Long points;

    private Long organisationId;

}