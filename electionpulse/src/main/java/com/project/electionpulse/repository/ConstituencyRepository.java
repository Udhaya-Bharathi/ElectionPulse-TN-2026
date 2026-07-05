package com.project.electionpulse.repository;

import com.project.electionpulse.entity.Constituency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConstituencyRepository extends JpaRepository<Constituency,Long> {
    Optional<Constituency>findByAcNumber(Integer acNumber);
}
