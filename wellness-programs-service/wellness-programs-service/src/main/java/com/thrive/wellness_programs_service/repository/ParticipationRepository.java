package com.thrive.wellness_programs_service.repository;

import com.thrive.wellness_programs_service.entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParticipationRepository   extends JpaRepository<Participation ,Long> {
}
