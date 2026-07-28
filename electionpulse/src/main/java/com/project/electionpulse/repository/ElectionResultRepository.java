package com.project.electionpulse.repository;

import com.project.electionpulse.dto.AlliancePerformanceDTO;
import com.project.electionpulse.dto.PartyPerformanceDTO;
import com.project.electionpulse.entity.Electionresult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionResultRepository extends JpaRepository<Electionresult, Long> {

    @Query("""
        SELECT er
        FROM Electionresult er
        WHERE er.election.year = :year
    """)
    List<Electionresult> findByElectionYear(@Param("year") int year);




  
}