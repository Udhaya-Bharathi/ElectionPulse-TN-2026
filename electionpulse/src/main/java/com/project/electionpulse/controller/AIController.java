package com.project.electionpulse.controller;

import com.project.electionpulse.dto.AIRequest;
import com.project.electionpulse.dto.AIResponse;
import com.project.electionpulse.service.AIAnalysisService;
import com.project.electionpulse.service.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class AIController {


    private final AIAnalysisService aiAnalysisService;
    public AIController(AIAnalysisService aiAnalysisService) {
        this.aiAnalysisService = aiAnalysisService;
    }



    @PostMapping("/analyze")
    public AIResponse analyze(@RequestBody AIRequest request) {

        String prompt = """
                You are an expert election analyst.

                Answer professionally and concisely.

                Question:
                %s
                """.formatted(request.getQuestion());

        String answer = aiAnalysisService.analyzeDistrict(request.getQuestion());

        return new AIResponse(answer);
    }
}