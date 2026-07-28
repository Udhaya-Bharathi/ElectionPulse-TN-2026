package com.project.electionpulse.controller;



import com.project.electionpulse.dto.PromptRequest;
import com.project.electionpulse.dto.PromptResponse;
import com.project.electionpulse.service.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gemini")
public class GeminiController {

    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/ask")
    public PromptResponse ask(@RequestBody PromptRequest request) {
        String reply = geminiService.generateResponse(request.getPrompt());
        return new PromptResponse(reply);
    }
}
