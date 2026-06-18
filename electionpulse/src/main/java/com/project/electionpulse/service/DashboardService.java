package com.project.electionpulse.service;

import com.project.electionpulse.dto.DashboardStats;
import com.project.electionpulse.repository.DistrictRepository;
import com.project.electionpulse.repository.PartyRepository;
import com.project.electionpulse.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private DistrictRepository districtRepository;

    public DashboardStats getStats() {

        return new DashboardStats(
                partyRepository.count(),
                regionRepository.count(),
                districtRepository.count()
        );
    }
}
