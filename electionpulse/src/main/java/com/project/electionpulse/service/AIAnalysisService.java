package com.project.electionpulse.service;

import com.project.electionpulse.dto.DistrictPerformanceDTO;
import org.springframework.stereotype.Service;

@Service
public class AIAnalysisService {

    private final AnalyticsService analyticsService;
    private final GeminiService geminiService;
    private final PromptBuilderService promptBuilderService;
    private final DistrictAliasService aliasService;

    public AIAnalysisService(AnalyticsService analyticsService, GeminiService geminiService, PromptBuilderService promptBuilderService, DistrictAliasService aliasService) {
        this.analyticsService = analyticsService;
        this.geminiService = geminiService;
        this.promptBuilderService = promptBuilderService;
        this.aliasService = aliasService;
    }

    public String analyzeDistrict(String districtName) {

        DistrictPerformanceDTO dto =
                analyticsService.getDistrictDetails(districtName);

        String prompt = promptBuilderService.buildDistrictPrompt(dto);


        return geminiService.askGemini(prompt);
    }
}