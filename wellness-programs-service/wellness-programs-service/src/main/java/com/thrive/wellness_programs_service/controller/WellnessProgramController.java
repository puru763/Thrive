package com.thrive.wellness_programs_service.controller;


import com.thrive.wellness_programs_service.entity.dto.ActivityDTO;
import com.thrive.wellness_programs_service.entity.dto.WellnessProgramDTO;
import com.thrive.wellness_programs_service.repository.ActivityRepository;
import com.thrive.wellness_programs_service.repository.ParticipationRepository;
import com.thrive.wellness_programs_service.repository.WellnessProgramRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activity")
public class WellnessProgramController {

    final WellnessProgramRepository wellnessProgramRepository;
    final ActivityRepository activityRepository;
    final ParticipationRepository participationRepository;

    public WellnessProgramController(WellnessProgramRepository wellnessProgramRepository, ActivityRepository activityRepository, ParticipationRepository participationRepository) {
        this.wellnessProgramRepository = wellnessProgramRepository;
        this.activityRepository = activityRepository;
        this.participationRepository = participationRepository;
    }


    @PostMapping("/create-Wellness-Program")
    public ResponseEntity<WellnessProgramDTO> createWellnessProgram(@RequestBody  WellnessProgramDTO wellnessProgramDTO){
            WellnessProgramDTO  wellnessProgram =  wellnessProgramRepository.createWellnessProgram(wellnessProgramDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(wellnessProgram);
    }


    @GetMapping("/{id}")
    public ResponseEntity<WellnessProgramDTO>getWellnessProgramById(@PathVariable("id") Long  id ){
        WellnessProgramDTO wellnessProgramDTO = wellnessProgramRepository.findbyId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(wellnessProgramDTO);

    }

    //getProgramsByOrganization          creete  in      user  service  make





}
