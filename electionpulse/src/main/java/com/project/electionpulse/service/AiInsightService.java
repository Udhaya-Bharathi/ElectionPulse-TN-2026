package com.project.electionpulse.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AiInsightService {

    private final Client geminiClient;
    private final AnalyticsService analyticsService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${gemini.model}")
    private String model;

    public AiInsightService(Client geminiClient, AnalyticsService analyticsService) {
        this.geminiClient = geminiClient;
        this.analyticsService = analyticsService;
    }

    public String answer(String question) {
        try {
            // 1. Gather a compact analytics snapshot — not raw 4257 records
            Map<String, Object> context = Map.of(
                    "districtPerformance", analyticsService.getDistrictPerformance(),
                    "partyPerformance", analyticsService.getPartyPerformance(),
                    "alliancePerformance", analyticsService.getAlliancePerformance(),
                    "topWinningMargins", analyticsService.getTopWinningMargins(10),
                    "closestContests", analyticsService.getClosestContests(10)
            );

            String contextJson = objectMapper.writeValueAsString(context);

            String prompt = """
                You are an election data analyst for the 2026 Tamil Nadu Assembly Election.
                Answer the user's question using ONLY the JSON data provided below.
                If the data doesn't contain enough information to answer, say so clearly —
                do not guess or invent numbers.

                DATA:
                %s

                QUESTION:
                %s

                Answer concisely in plain English, citing specific numbers from the data where relevant.
                """.formatted(contextJson, question);

            GenerateContentResponse response =
                    geminiClient.models.generateContent(model, prompt, null);

            return response.text();

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate AI insight: " + e.getMessage(), e);
        }
    }
}