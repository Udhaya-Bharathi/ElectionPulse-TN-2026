package com.project.electionpulse.repository;

import com.project.electionpulse.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository  extends JpaRepository<District,Long> {
}
