package com.project.electionpulse.dto;

public class DashboardStats {



        private long partyCount;
        private long regionCount;
        private long districtCount;

        public DashboardStats(long partyCount,
                              long regionCount,
                              long districtCount) {

            this.partyCount = partyCount;
            this.regionCount = regionCount;
            this.districtCount = districtCount;
        }

        public long getPartyCount() {
            return partyCount;
        }

        public long getRegionCount() {
            return regionCount;
        }

        public long getDistrictCount() {
            return districtCount;
        }

}
