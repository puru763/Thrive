package com.thrive.wellness_programs_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "wellnessprogram")
public class WellnessProgram {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  wellnessProgramid;

    private String name;
    private String description;

    @NotNull
    private Long  OrganisationId;

    @OneToMany(mappedBy = "wellnessProgram", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Activity> activities;

    @OneToMany(mappedBy = "wellnessProgram", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Participation> participations;
}
