package com.project.electionpulse.repository;

import com.project.electionpulse.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElectionRepository extends JpaRepository<Election,Long> {
    Optional<Election> findByYear(Integer year);
}
