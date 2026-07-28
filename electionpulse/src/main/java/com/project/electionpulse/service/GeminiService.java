package com.project.electionpulse.service;



import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    private final Client client;

    @Value("${gemini.model}")
    private String model;

    public GeminiService(Client client) {
        this.client = client;
    }

    public String generateResponse(String prompt) {
        GenerateContentResponse response =
                client.models.generateContent(model, prompt, null);
        return response.text();
    }
}