package com.project.electionpulse.controller;



import com.project.electionpulse.dto.AiInsightRequest;
import com.project.electionpulse.dto.AiInsightResponse;
import com.project.electionpulse.service.AiInsightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiInsightController {

    private final AiInsightService aiInsightService;

    public AiInsightController(AiInsightService aiInsightService) {
        this.aiInsightService = aiInsightService;
    }

    @PostMapping("/insight")
    public AiInsightResponse getInsight(@RequestBody AiInsightRequest request) {
        String answer = aiInsightService.answer(request.getQuestion());
        return new AiInsightResponse(answer);
    }
}
