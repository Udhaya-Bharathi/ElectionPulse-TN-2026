package com.project.electionpulse.controller;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AiController {

    @GetMapping("/api/chat")
    public String askAI(@RequestParam String prompt) {
        String apiKey = System.getenv("GOOGLE_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            return "Error: GOOGLE_API_KEY environment variable is missing!";
        }

        try {
            Client client = new Client();
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-2.5-flash",
                    prompt,
                    null
            );
            return response.text();

        } catch (Exception e) {
            return "AI Error: " + e.getMessage();
        }
    }
}