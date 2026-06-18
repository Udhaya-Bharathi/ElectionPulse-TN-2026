package com.project.electionpulse.repository;

import com.project.electionpulse.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party,Long> {

}
