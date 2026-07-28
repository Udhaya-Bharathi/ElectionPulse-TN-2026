package com.project.electionpulse.dto;

public class PartyPerformanceDTO {


        private String party;
        private Long seats;

        public PartyPerformanceDTO(String party, Long seats) {
            this.party = party;
            this.seats = seats;
        }

        public String getParty() {
            return party;
        }

        public Long getSeats() {
            return seats;
        }

}
