package com.project.electionpulse.repository;

import com.project.electionpulse.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartyRepository extends JpaRepository<Party,Long> {
    Optional<Party> findBySmallName(String smallName);

}
