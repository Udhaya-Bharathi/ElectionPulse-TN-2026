package com.project.electionpulse.service;

import com.project.electionpulse.dto.DashboardStats;
import com.project.electionpulse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DashboardService {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ConstituencyRepository constituencyRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private AllianceRepository allianceRepository;

    @Autowired
    private ElectionResultRepository electionResultRepository;

    public DashboardStats getDashboardStats() {

        return new DashboardStats(
                regionRepository.count(),
                districtRepository.count(),
                constituencyRepository.count(),
                partyRepository.count(),
                allianceRepository.count(),
                electionResultRepository.count()
        );
    }
}