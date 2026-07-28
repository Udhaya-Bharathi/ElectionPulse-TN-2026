package com.project.electionpulse.dto;

    public class DistrictAllianceStatsDTO {

        private String district;
        private String alliance;
        private Long seatsWon;
        private Long votes;

        public DistrictAllianceStatsDTO(String district,
                                        String alliance,
                                        Long seatsWon,
                                        Long votes) {
            this.district = district;
            this.alliance = alliance;
            this.seatsWon = seatsWon;
            this.votes = votes;
        }

        public String getDistrict() {
            return district;
        }

        public String getAlliance() {
            return alliance;
        }

        public Long getSeatsWon() {
            return seatsWon;
        }

        public Long getVotes() {
            return votes;
        }


    }
