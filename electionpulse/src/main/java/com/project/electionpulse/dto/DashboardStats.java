package com.project.electionpulse.dto;
public class DashboardStats{

    private long regions;
    private long districts;
    private long constituencies;
    private long parties;
    private long alliances;
    private long candidates;

    public DashboardStats() {
    }

    public DashboardStats(long regions,
                             long districts,
                             long constituencies,
                             long parties,
                             long alliances,
                             long candidates) {
        this.regions = regions;
        this.districts = districts;
        this.constituencies = constituencies;
        this.parties = parties;
        this.alliances = alliances;
        this.candidates = candidates;
    }

    public long getRegions() {
        return regions;
    }

    public void setRegions(long regions) {
        this.regions = regions;
    }

    public long getDistricts() {
        return districts;
    }

    public void setDistricts(long districts) {
        this.districts = districts;
    }

    public long getConstituencies() {
        return constituencies;
    }

    public void setConstituencies(long constituencies) {
        this.constituencies = constituencies;
    }

    public long getParties() {
        return parties;
    }

    public void setParties(long parties) {
        this.parties = parties;
    }

    public long getAlliances() {
        return alliances;
    }

    public void setAlliances(long alliances) {
        this.alliances = alliances;
    }

    public long getCandidates() {
        return candidates;
    }

    public void setCandidates(long candidates) {
        this.candidates = candidates;
    }
}