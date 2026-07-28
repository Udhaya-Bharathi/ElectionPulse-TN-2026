package com.project.electionpulse.dto;

public class PromptResponse {
    private String reply;

    public PromptResponse(String reply) { this.reply = reply; }

    public String getReply() { return reply; }
    public void setReply(String reply) { this.reply = reply; }
}