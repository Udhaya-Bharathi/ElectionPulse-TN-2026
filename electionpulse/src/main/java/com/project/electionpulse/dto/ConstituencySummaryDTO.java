package com.project.electionpulse.dto;

public class ConstituencySummaryDTO {

    private String constituency;

    private String winner;
    private String winnerParty;

    private String runnerUp;
    private String runnerUpParty;

    private long marginVotes;

    private double marginPercentage;

    public ConstituencySummaryDTO(String constituency, String winner, String winnerParty, String runnerUp, String runnerUpParty, long marginVotes, double marginPercentage) {
        this.constituency = constituency;
        this.winner = winner;
        this.winnerParty = winnerParty;
        this.runnerUp = runnerUp;
        this.runnerUpParty = runnerUpParty;
        this.marginVotes = marginVotes;
        this.marginPercentage = marginPercentage;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getWinnerParty() {
        return winnerParty;
    }

    public void setWinnerParty(String winnerParty) {
        this.winnerParty = winnerParty;
    }

    public String getRunnerUp() {
        return runnerUp;
    }

    public void setRunnerUp(String runnerUp) {
        this.runnerUp = runnerUp;
    }

    public String getRunnerUpParty() {
        return runnerUpParty;
    }

    public void setRunnerUpParty(String runnerUpParty) {
        this.runnerUpParty = runnerUpParty;
    }

    public long getMarginVotes() {
        return marginVotes;
    }

    public void setMarginVotes(long marginVotes) {
        this.marginVotes = marginVotes;
    }

    public double getMarginPercentage() {
        return marginPercentage;
    }

    public void setMarginPercentage(double marginPercentage) {
        this.marginPercentage = marginPercentage;
    }
}
