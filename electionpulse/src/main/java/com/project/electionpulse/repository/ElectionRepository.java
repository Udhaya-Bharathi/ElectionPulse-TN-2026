package com.project.electionpulse.repository;

import com.project.electionpulse.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election,Long> {
}
