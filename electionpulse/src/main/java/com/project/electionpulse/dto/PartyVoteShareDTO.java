package com.project.electionpulse.dto;

public class PartyVoteShareDTO {


        private String party;
        private long votes;
        private double voteShare;

        public PartyVoteShareDTO() {
        }

        public PartyVoteShareDTO(String party, long votes, double voteShare) {
            this.party = party;
            this.votes = votes;
            this.voteShare = voteShare;
        }

        public String getParty() {
            return party;
        }

        public void setParty(String party) {
            this.party = party;
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
