package com.project.electionpulse.service;

import com.project.electionpulse.config.GeminiConfig;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    private final RestClient restClient;
    private final GeminiConfig geminiConfig;

    public GeminiService(GeminiConfig geminiConfig) {
        this.geminiConfig = geminiConfig;

        this.restClient = RestClient.builder()
                .baseUrl("https://generativelanguage.googleapis.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("x-goog-api-key", geminiConfig.getApiKey())
                .build();
    }

    public String askGemini(String prompt) {

        Map<String, Object> body = Map.of(
                "contents", List.of(
                        Map.of(
                                "parts", List.of(
                                        Map.of("text", prompt)
                                )
                        )
                )
        );

        try {

            Map<?, ?> response = restClient.post()
                    .uri("/v1beta/models/" + geminiConfig.getModel() + ":generateContent")
                    .body(body)
                    .retrieve()
                    .body(Map.class);

            return extractText(response);

        } catch (Exception e) {

            e.printStackTrace();

            return "Gemini API Error : " + e.getMessage();
        }
    }

    private String extractText(Map<?, ?> response) {

        try {

            List<?> candidates = (List<?>) response.get("candidates");

            Map<?, ?> candidate = (Map<?, ?>) candidates.get(0);

            Map<?, ?> content = (Map<?, ?>) candidate.get("content");

            List<?> parts = (List<?>) content.get("parts");

            Map<?, ?> firstPart = (Map<?, ?>) parts.get(0);

            return firstPart.get("text").toString();

        } catch (Exception e) {

            return "Unable to read Gemini response.";
        }
    }
}