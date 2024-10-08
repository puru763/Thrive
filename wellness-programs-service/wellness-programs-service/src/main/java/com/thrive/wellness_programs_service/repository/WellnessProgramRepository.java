package com.thrive.wellness_programs_service.repository;

import com.thrive.wellness_programs_service.entity.WellnessProgram;
import com.thrive.wellness_programs_service.entity.dto.WellnessProgramDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WellnessProgramRepository   extends JpaRepository<WellnessProgram ,Long> {
    WellnessProgramDTO createWellnessProgram(WellnessProgramDTO wellnessProgramDTO);

    WellnessProgramDTO findbyId(Long id);
}
