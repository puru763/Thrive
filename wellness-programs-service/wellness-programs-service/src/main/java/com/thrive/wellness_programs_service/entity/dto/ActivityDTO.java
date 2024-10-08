package com.thrive.wellness_programs_service.entity.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;



@Data
public class ActivityDTO {

    @NotNull
    private Long WellnessProgramId;

    private  String name;
    private String description;
    private  Long points;
    private Long organisationId;
}
