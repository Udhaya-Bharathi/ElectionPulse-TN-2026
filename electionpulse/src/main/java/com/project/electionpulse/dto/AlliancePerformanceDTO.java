package com.project.electionpulse.dto;

public class AlliancePerformanceDTO {

        private String alliance;
        private Long seats;

        public AlliancePerformanceDTO(String alliance, Long seats) {
            this.alliance = alliance;
            this.seats = seats;
        }

        public String getAlliance() {
            return alliance;
        }

        public Long getSeats() {
            return seats;
        }

}
