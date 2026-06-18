package com.project.electionpulse.repository;

import com.project.electionpulse.entity.Constituency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstituencyRepository extends JpaRepository<Constituency,Long> {
}
