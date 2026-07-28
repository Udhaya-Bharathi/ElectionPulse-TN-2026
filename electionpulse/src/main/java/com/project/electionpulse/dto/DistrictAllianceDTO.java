package com.project.electionpulse.dto;

    public class DistrictAllianceDTO {

        private String alliance;

        private long seats;

        private double seatShare;

        private long votes;

        private double voteShare;

        public DistrictAllianceDTO(String alliance, long seats, double seatShare, long votes, double voteShare) {
            this.alliance = alliance;
            this.seats = seats;
            this.seatShare = seatShare;
            this.votes = votes;
            this.voteShare = voteShare;
        }

        public String getAlliance() {
            return alliance;
        }

        public void setAlliance(String alliance) {
            this.alliance = alliance;
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
