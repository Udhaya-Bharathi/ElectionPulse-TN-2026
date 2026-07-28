package com.project.electionpulse.dto;

import java.util.List;

public class DistrictPerformanceDTO {
    private String district;

    private long totalSeats;

    private long totalVotes;



    private String seatLeader;

    private String voteLeader;

    private double averageVictoryMargin;

    private MarginDTO largestVictory;

    private MarginDTO closestContest;

    private List<DistrictAllianceDTO> allianceBreakdown;

    private List<DistrictPartyDTO> partyBreakdown;

    private List<ConstituencySummaryDTO> constituencies;

    public DistrictPerformanceDTO() {
    }
    public DistrictPerformanceDTO(String district, long totalSeats, long totalVotes, String districtStatus, String seatLeader, String voteLeader, double averageVictoryMargin, MarginDTO largestVictory, MarginDTO closestContest, List<DistrictAllianceDTO> allianceBreakdown, List<DistrictPartyDTO> partyBreakdown, List<ConstituencySummaryDTO> constituencies) {
        this.district = district;
        this.totalSeats = totalSeats;
        this.totalVotes = totalVotes;

        this.seatLeader = seatLeader;
        this.voteLeader = voteLeader;
        this.averageVictoryMargin = averageVictoryMargin;
        this.largestVictory = largestVictory;
        this.closestContest = closestContest;
        this.allianceBreakdown = allianceBreakdown;
        this.partyBreakdown = partyBreakdown;
        this.constituencies = constituencies;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public long getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(long totalSeats) {
        this.totalSeats = totalSeats;
    }

    public long getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(long totalVotes) {
        this.totalVotes = totalVotes;
    }



    public String getSeatLeader() {
        return seatLeader;
    }

    public void setSeatLeader(String seatLeader) {
        this.seatLeader = seatLeader;
    }

    public String getVoteLeader() {
        return voteLeader;
    }

    public void setVoteLeader(String voteLeader) {
        this.voteLeader = voteLeader;
    }

    public double getAverageVictoryMargin() {
        return averageVictoryMargin;
    }

    public void setAverageVictoryMargin(double averageVictoryMargin) {
        this.averageVictoryMargin = averageVictoryMargin;
    }

    public MarginDTO getLargestVictory() {
        return largestVictory;
    }

    public void setLargestVictory(MarginDTO largestVictory) {
        this.largestVictory = largestVictory;
    }

    public MarginDTO getClosestContest() {
        return closestContest;
    }

    public void setClosestContest(MarginDTO closestContest) {
        this.closestContest = closestContest;
    }

    public List<DistrictAllianceDTO> getAllianceBreakdown() {
        return allianceBreakdown;
    }

    public void setAllianceBreakdown(List<DistrictAllianceDTO> allianceBreakdown) {
        this.allianceBreakdown = allianceBreakdown;
    }

    public List<DistrictPartyDTO> getPartyBreakdown() {
        return partyBreakdown;
    }

    public void setPartyBreakdown(List<DistrictPartyDTO> partyBreakdown) {
        this.partyBreakdown = partyBreakdown;
    }

    public List<ConstituencySummaryDTO> getConstituencies() {
        return constituencies;
    }

    public void setConstituencies(List<ConstituencySummaryDTO> constituencies) {
        this.constituencies = constituencies;
    }

    private long seatLeaderSeats;

    public long getSeatLeaderSeats() {
        return seatLeaderSeats;
    }

    public void setSeatLeaderSeats(long seatLeaderSeats) {
        this.seatLeaderSeats = seatLeaderSeats;
    }

    private double voteLeaderShare;

    public double getVoteLeaderShare() {
        return voteLeaderShare;
    }

    public void setVoteLeaderShare(double voteLeaderShare) {
        this.voteLeaderShare = voteLeaderShare;
    }
}


