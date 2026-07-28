package com.project.electionpulse.dto;

public class AllianceVoteShareDTO {

        private String alliance;
        private long votes;
        private double voteShare;

        public AllianceVoteShareDTO() {
        }

        public AllianceVoteShareDTO(String alliance, long votes, double voteShare) {
            this.alliance = alliance;
            this.votes = votes;
            this.voteShare = voteShare;
        }

        public String getAlliance() {
            return alliance;
        }

        public void setAlliance(String alliance) {
            this.alliance = alliance;
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
