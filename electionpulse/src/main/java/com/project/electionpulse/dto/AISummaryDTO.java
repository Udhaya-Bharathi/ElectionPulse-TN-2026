package com.project.electionpulse.dto;



import java.util.List;

public class AISummaryDTO {

    private String title;
    private List<String> insights;

    public AISummaryDTO() {
    }

    public AISummaryDTO(String title, List<String> insights) {
        this.title = title;
        this.insights = insights;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getInsights() {
        return insights;
    }

    public void setInsights(List<String> insights) {
        this.insights = insights;
    }
}