package com.project.electionpulse.repository;

import com.project.electionpulse.entity.Electionresult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionResultRepository extends JpaRepository<Electionresult,Long> {
}
