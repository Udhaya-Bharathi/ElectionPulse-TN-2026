package com.project.electionpulse.controller;

import com.project.electionpulse.dto.DistrictPerformanceDTO;
import com.project.electionpulse.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.electionpulse.dto.AlliancePerformanceDTO;
import com.project.electionpulse.dto.PartyPerformanceDTO;
import java.util.List;
import com.project.electionpulse.dto.AllianceVoteShareDTO;
import com.project.electionpulse.dto.PartyVoteShareDTO;

import com.project.electionpulse.service.AnalyticsAIService;
import com.project.electionpulse.dto.AISummaryDTO;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = "*")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;
    @Autowired
    private AnalyticsAIService analyticsAIService;

    @GetMapping("/district-performance")
    public List<DistrictPerformanceDTO> getDistrictPerformance() {

        return analyticsService.getDistrictPerformance();
    }
    @GetMapping("/district/{districtName}")
    public DistrictPerformanceDTO getDistrictDetails(
            @PathVariable String districtName) {

        return analyticsService.getDistrictDetails(districtName);
    }

    @GetMapping("/alliance-performance")
    public List<AlliancePerformanceDTO> getAlliancePerformance() {

        return analyticsService.getAlliancePerformance();

    }

    @GetMapping("/party-performance")
    public List<PartyPerformanceDTO> getPartyPerformance() {

        return analyticsService.getPartyPerformance();

    }
    @GetMapping("/alliance-vote-share")
    public List<AllianceVoteShareDTO> getAllianceVoteShare() {

        return analyticsService.getAllianceVoteShare();

    }

    @GetMapping("/party-vote-share")
    public List<PartyVoteShareDTO> getPartyVoteShare() {

        return analyticsService.getPartyVoteShare();

    }
    @GetMapping("/ai-summary")
    public AISummaryDTO getAISummary() {

        return analyticsAIService.generateSummary();

    }
}


