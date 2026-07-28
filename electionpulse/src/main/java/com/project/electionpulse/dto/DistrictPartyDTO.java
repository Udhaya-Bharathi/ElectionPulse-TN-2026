package com.project.electionpulse.dto;

public class DistrictPartyDTO {


        private String party;

        private long seats;

        private double seatShare;

        private long votes;

        private double voteShare;

        public DistrictPartyDTO() {}

        public DistrictPartyDTO(
                String party,
                long seats,
                double seatShare,
                long votes,
                double voteShare) {

            this.party = party;
            this.seats = seats;
            this.seatShare = seatShare;
            this.votes = votes;
            this.voteShare = voteShare;
        }

        // getters & setters

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public long getSeats() {
        return seats;
    }

    public void setSeats(long seats) {
        this.seats = seats;
    }

    public double getSeatShare() {
        return seatShare;
    }

    public void setSeatShare(double seatShare) {
        this.seatShare = seatShare;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    public double getVoteShare() {
        return voteShare;
    }

    public void setVoteShare(double voteShare) {
        this.voteShare = voteShare;
    }
}
