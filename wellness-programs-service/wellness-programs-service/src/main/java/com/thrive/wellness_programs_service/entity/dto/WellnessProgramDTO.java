package com.thrive.wellness_programs_service.entity.dto;

import com.thrive.wellness_programs_service.entity.Activity;
import com.thrive.wellness_programs_service.entity.Participation;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;


@Data
public class WellnessProgramDTO {
    private String name;
    private String description;

    @NotNull
    private Long  OrganisationId;

    private List<Activity> activities;
    private  List<Participation> participations;
}
