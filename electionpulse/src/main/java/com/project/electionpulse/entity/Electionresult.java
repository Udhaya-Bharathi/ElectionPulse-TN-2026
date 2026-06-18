package com.project.electionpulse.entity;

import jakarta.persistence.*;

@Entity
@Table(name="electionresult")
public class Electionresult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name="constituency_id")
    private Constituency constituency;

    @ManyToOne
    @JoinColumn(name="party_id")
    private Party party;

    @ManyToOne
    @JoinColumn(name="alliance_id")
    private Alliance alliance ;

    @ManyToOne
    @JoinColumn(name="election_id")
    private Election election;

    private Long votes;

    private Double voteshare;

    private Integer rank;

    private Boolean winner;



    public Electionresult() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Constituency getConstituency() {
        return constituency;
    }

    public void setConstituency(Constituency constituency) {
        this.constituency = constituency;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }

    public Double getVoteshare() {
        return voteshare;
    }

    public void setVoteshare(Double voteshare) {
        this.voteshare = voteshare;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }
}

