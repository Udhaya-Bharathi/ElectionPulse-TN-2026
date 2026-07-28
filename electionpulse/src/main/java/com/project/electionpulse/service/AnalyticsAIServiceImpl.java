package com.project.electionpulse.service;



import com.project.electionpulse.dto.*;
import com.project.electionpulse.service.AnalyticsAIService;
import com.project.electionpulse.service.AnalyticsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticsAIServiceImpl implements AnalyticsAIService {

    private final AnalyticsService analyticsService;

    public AnalyticsAIServiceImpl(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @Override
    public AISummaryDTO generateSummary() {

        List<AlliancePerformanceDTO> alliances =
                analyticsService.getAlliancePerformance();

        List<AllianceVoteShareDTO> votes =
                analyticsService.getAllianceVoteShare();

        List<String> insights = new ArrayList<>();

        AlliancePerformanceDTO winner = alliances.get(0);

        insights.add(
                winner.getAlliance() +
                        " emerged as the largest alliance with " +
                        winner.getSeats() +
                        " seats."
        );

        for (AllianceVoteShareDTO vote : votes) {

            if ("NTK".equals(vote.getAlliance())) {

                insights.add(
                        "NTK secured "
                                + vote.getVoteShare()
                                + "% vote share despite not winning seats."
                );

            }

            if ("NOTA".equals(vote.getAlliance())) {

                insights.add(
                        "NOTA accounted for "
                                + vote.getVoteShare()
                                + "% of total votes."
                );

            }

        }

        insights.add(
                "The election witnessed a competitive three-alliance contest among TVK, SPA and NDA."
        );

        insights.add(
                winner.getAlliance() +
                        " controls " +
                        String.format("%.2f",
                                winner.getSeats() * 100.0 / 234)
                        + "% of the Assembly."
        );

        return new AISummaryDTO(
                "AI Election Insights",
                insights
        );

    }

}