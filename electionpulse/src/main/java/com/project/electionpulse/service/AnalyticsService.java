package com.project.electionpulse.service;

import com.project.electionpulse.dto.*;
import com.project.electionpulse.entity.Electionresult;
import com.project.electionpulse.repository.ElectionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnalyticsService {

    private static final Set<String> MAJOR_ALLIANCES =
            Set.of("SPA", "NDA", "TVK");
    @Autowired
    private ElectionResultRepository electionResultRepository;

    private List<Electionresult> getWinners(List<Electionresult> results) {

        Map<String, List<Electionresult>> constituencyMap =
                results.stream()
                        .collect(Collectors.groupingBy(
                                r -> r.getConstituency().getName()
                        ));

        return constituencyMap.values()
                .stream()
                .map(list -> list.stream()
                        .max(Comparator.comparing(Electionresult::getVotes))
                        .orElse(null))
                .filter(java.util.Objects::nonNull)
                .toList();
    }
    public List<DistrictPerformanceDTO> getDistrictPerformance() {

        List<Electionresult> results =
                electionResultRepository.findByElectionYear(2026);

        List<Electionresult> winners = getWinners(results);

        Map<String, List<Electionresult>> districtWinnerMap =
                winners.stream()
                        .collect(Collectors.groupingBy(
                                r -> r.getConstituency()
                                        .getDistrict()
                                        .getName()
                        ));

        List<DistrictPerformanceDTO> districtList = new ArrayList<>();

        for (Map.Entry<String, List<Electionresult>> districtEntry : districtWinnerMap.entrySet()) {

            String district = districtEntry.getKey();

            List<Electionresult> districtWinners = districtEntry.getValue();

            long totalSeats = districtWinners.size();

            List<Electionresult> districtResults =
                    results.stream()
                            .filter(r ->
                                    r.getConstituency()
                                            .getDistrict()
                                            .getName()
                                            .equals(district))
                            .toList();

            long totalVotes =
                    districtResults.stream()
                            .mapToLong(Electionresult::getVotes)
                            .sum();

            Map<String, Long> seatMap =
                    districtWinners.stream()
                            .collect(Collectors.groupingBy(
                                    r -> r.getAlliance() == null
                                            ? "Independent"
                                            : r.getAlliance().getName(),
                                    Collectors.counting()
                            ));

            long seatLeaderSeats =
                    seatMap.values()
                            .stream()
                            .max(Long::compareTo)
                            .orElse(0L);

            List<String> seatLeaders =
                    seatMap.entrySet()
                            .stream()
                            .filter(e -> e.getValue().equals(seatLeaderSeats))
                            .map(Map.Entry::getKey)
                            .sorted()
                            .toList();

            String seatLeader = String.join(" / ", seatLeaders);



            Map<String, Long> allianceVoteMap =
                    districtResults.stream()
                            .collect(Collectors.groupingBy(
                                    r -> r.getAlliance() == null
                                            ? "Independent"
                                            : r.getAlliance().getName(),
                                    Collectors.summingLong(Electionresult::getVotes)
                            ));

            String voteLeader =
                    allianceVoteMap.entrySet()
                            .stream()
                            .max(Map.Entry.comparingByValue())
                            .map(Map.Entry::getKey)
                            .orElse("NA");

            long voteLeaderVotes =
                    allianceVoteMap.getOrDefault(voteLeader, 0L);

            double voteLeaderShare =
                    totalVotes == 0
                            ? 0
                            : Math.round(
                            (voteLeaderVotes * 10000.0) / totalVotes
                    ) / 100.0;

            DistrictPerformanceDTO dto = new DistrictPerformanceDTO();

            dto.setDistrict(district);

            dto.setTotalSeats(totalSeats);

            dto.setTotalVotes(totalVotes);



            if (seatLeaders.size() > 1) {
                seatLeader = "TIED (" + String.join(" / ", seatLeaders) + ")";
            } else {
                seatLeader = seatLeaders.get(0);
            }

            dto.setSeatLeader(seatLeader);
            dto.setSeatLeaderSeats(seatLeaderSeats);



            dto.setVoteLeader(
                    voteLeader
            );

            dto.setAverageVictoryMargin(0);

            dto.setAllianceBreakdown(new ArrayList<>());

            dto.setPartyBreakdown(new ArrayList<>());

            dto.setConstituencies(new ArrayList<>());

            dto.setSeatLeaderSeats(seatLeaderSeats);

            dto.setVoteLeaderShare(voteLeaderShare);
            districtList.add(dto);
        }

        districtList.sort(
                Comparator.comparing(DistrictPerformanceDTO::getDistrict)
        );

        return districtList;
    }
    public DistrictPerformanceDTO getDistrictDetails(String districtName) {
        List<Electionresult> results =
                electionResultRepository.findByElectionYear(2026);

        List<Electionresult> districtResults =
                results.stream()
                        .filter(r ->
                                r.getConstituency()
                                        .getDistrict()
                                        .getName()
                                        .equalsIgnoreCase(districtName))
                        .toList();
        List<Electionresult> districtWinners =
                getWinners(districtResults);

        DistrictPerformanceDTO dto =
                new DistrictPerformanceDTO();

        dto.setDistrict(districtName);

        dto.setTotalSeats(districtWinners.size());

        long totalVotes =
                districtResults.stream()
                        .mapToLong(Electionresult::getVotes)
                        .sum();

        dto.setTotalVotes(totalVotes);

        Map<String, Long> seatMap =
                districtWinners.stream()
                        .collect(Collectors.groupingBy(
                                r -> r.getAlliance() == null
                                        ? "Independent"
                                        : r.getAlliance().getName(),
                                Collectors.counting()
                        ));

        long seatLeaderSeats =
                seatMap.values()
                        .stream()
                        .max(Long::compareTo)
                        .orElse(0L);

        List<String> seatLeaders =
                seatMap.entrySet()
                        .stream()
                        .filter(e -> e.getValue().equals(seatLeaderSeats))
                        .map(Map.Entry::getKey)
                        .sorted()
                        .toList();

        String seatLeader;

        if (seatLeaders.size() > 1) {
            seatLeader = "TIED (" + String.join(" / ", seatLeaders) + ")";
        }
        else {
            seatLeader = seatLeaders.get(0);
        }

        dto.setSeatLeader(seatLeader);
        dto.setSeatLeaderSeats(seatLeaderSeats);
        Map<String, Long> allianceVoteMap =
                districtResults.stream()
                        .collect(Collectors.groupingBy(
                                r -> r.getAlliance() == null
                                        ? "Independent"
                                        : r.getAlliance().getName(),
                                Collectors.summingLong(Electionresult::getVotes)
                        ));

        String voteLeader =
                allianceVoteMap.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse("NA");

        long voteLeaderVotes =
                allianceVoteMap.get(voteLeader);

        double voteLeaderShare =
                Math.round(
                        (voteLeaderVotes * 10000.0) / totalVotes
                ) / 100.0;

        dto.setVoteLeader(voteLeader);
        dto.setVoteLeaderShare(voteLeaderShare);
        dto.setAllianceBreakdown(new ArrayList<>());
        dto.setPartyBreakdown(new ArrayList<>());
        dto.setConstituencies(new ArrayList<>());

        dto.setLargestVictory(null);
        dto.setClosestContest(null);
        dto.setAverageVictoryMargin(0);



        //alliance breakdown
        Map<String, Long> allianceVotes =
                districtResults.stream()
                        .collect(Collectors.groupingBy(
                                r -> r.getAlliance() == null
                                        ? "Independent"
                                        : r.getAlliance().getName(),
                                Collectors.summingLong(Electionresult::getVotes)
                        ));

        Map<String, Long> allianceSeats =
                districtWinners.stream()
                        .collect(Collectors.groupingBy(
                                r -> r.getAlliance() == null
                                        ? "Independent"
                                        : r.getAlliance().getName(),
                                Collectors.counting()
                        ));

        List<DistrictAllianceDTO> allianceBreakdown = new ArrayList<>();

        for (Map.Entry<String, Long> entry : allianceVotes.entrySet()) {

            String alliance = entry.getKey();

            long votes = entry.getValue();

            long seats = allianceSeats.getOrDefault(alliance, 0L);

            double seatShare =
                    Math.round((seats * 10000.0) / districtWinners.size()) / 100.0;

            double voteShare =
                    Math.round((votes * 10000.0) / totalVotes) / 100.0;

            allianceBreakdown.add(
                    new DistrictAllianceDTO(
                            alliance,
                            seats,
                            seatShare,
                            votes,
                            voteShare
                    )
            );
        }
        allianceBreakdown.sort(
                Comparator.comparingLong(DistrictAllianceDTO::getSeats)
                        .thenComparingLong(DistrictAllianceDTO::getVotes)
                        .reversed()
        );
        dto.setAllianceBreakdown(allianceBreakdown);


        // =========================
// Party Breakdown
// =========================

        Map<String, Long> partyVotes =
                districtResults.stream()
                        .collect(Collectors.groupingBy(
                                this::getDisplayParty,
                                Collectors.summingLong(Electionresult::getVotes)
                        ));

        Map<String, Long> partySeats =
                districtWinners.stream()
                        .collect(Collectors.groupingBy(
                                this::getDisplayParty,
                                Collectors.counting()
                        ));

        List<DistrictPartyDTO> partyBreakdown = new ArrayList<>();

        for (Map.Entry<String, Long> entry : partyVotes.entrySet()) {

            String party = entry.getKey();

            long votes = entry.getValue();

            long seats = partySeats.getOrDefault(party, 0L);

            double seatShare =
                    Math.round((seats * 10000.0) / districtWinners.size()) / 100.0;

            double voteShare =
                    Math.round((votes * 10000.0) / totalVotes) / 100.0;

            partyBreakdown.add(
                    new DistrictPartyDTO(
                            party,
                            seats,
                            seatShare,
                            votes,
                            voteShare
                    )
            );
        }

        partyBreakdown.sort(
                Comparator.comparingLong(DistrictPartyDTO::getSeats)
                        .thenComparingLong(DistrictPartyDTO::getVotes)
                        .reversed()
        );

        dto.setPartyBreakdown(partyBreakdown);


        //constituency summaries

        Map<String, List<Electionresult>> constituencyMap =
                districtResults.stream()
                        .collect(Collectors.groupingBy(
                                r -> r.getConstituency().getName()
                        ));

        List<ConstituencySummaryDTO> constituencySummaries = new ArrayList<>();

        MarginDTO largestVictory = null;

        long largestMargin = -1;

        MarginDTO closestContest = null;

        long smallestMargin = Long.MAX_VALUE;

        long totalMargin = 0;
        for (List<Electionresult> constituencyResults : constituencyMap.values()) {

            constituencyResults.sort(
                    Comparator.comparingLong(Electionresult::getVotes)
                            .reversed()
            );

            Electionresult winner = constituencyResults.get(0);
            Electionresult runnerUp = constituencyResults.get(1);

            long margin = winner.getVotes() - runnerUp.getVotes();

            long totalConstituencyVotes =
                    constituencyResults.stream()
                            .mapToLong(Electionresult::getVotes)
                            .sum();

            double marginPercent =
                    Math.round((margin * 10000.0) / totalConstituencyVotes) / 100.0;
            if (margin > largestMargin) {

                largestMargin = margin;

                largestVictory = new MarginDTO(
                        winner.getConstituency().getName(),
                        winner.getCandidateName(),
                        winner.getParty().getSmallName(),
                        runnerUp.getCandidateName(),
                        runnerUp.getParty().getSmallName(),
                        margin,
                        marginPercent
                );
            }
            if (margin < smallestMargin) {

                smallestMargin = margin;

                closestContest = new MarginDTO(
                        winner.getConstituency().getName(),
                        winner.getCandidateName(),
                        winner.getParty().getSmallName(),
                        runnerUp.getCandidateName(),
                        runnerUp.getParty().getSmallName(),
                        margin,
                        marginPercent
                );

            }
            totalMargin += margin;
            constituencySummaries.add(
                    new ConstituencySummaryDTO(
                            winner.getConstituency().getName(),
                            winner.getCandidateName(),
                            winner.getParty().getSmallName(),
                            runnerUp.getCandidateName(),
                            runnerUp.getParty().getSmallName(),
                            margin,
                            marginPercent
                    )
            );
        }

        constituencySummaries.sort(
                Comparator.comparing(ConstituencySummaryDTO::getConstituency)
        );

        dto.setConstituencies(constituencySummaries);
        dto.setLargestVictory(largestVictory);
        dto.setClosestContest(closestContest);

        double averageMargin =
                Math.round((totalMargin * 100.0) / constituencySummaries.size()) / 100.0;

        dto.setAverageVictoryMargin(averageMargin);
        //margin analytics

        return dto;
    }
    //helper fn
    private String getDisplayParty(Electionresult result) {

        String alliance = result.getAlliance() == null
                ? ""
                : result.getAlliance().getName();

        String party = result.getParty().getSmallName();

        // Major alliances -> show individual parties
        if (MAJOR_ALLIANCES.contains(alliance)) {
            return party;
        }

        // NTK shown separately
        if ("NTK".equals(alliance)) {
            return "NTK";
        }

        // NOTA shown separately
        if ("NOTA".equalsIgnoreCase(party)) {
            return "NOTA";
        }

        // Everything else
        return "Others";
    }
    public List<AlliancePerformanceDTO> getAlliancePerformance() {

        List<Electionresult> results =
                electionResultRepository.findByElectionYear(2026);

        List<Electionresult> winners = getWinners(results);

        Map<String, Long> allianceSeats =
                winners.stream()
                        .collect(Collectors.groupingBy(
                                r -> r.getAlliance() == null
                                        ? "Independent"
                                        : r.getAlliance().getName(),
                                Collectors.counting()
                        ));

        return allianceSeats.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(e -> new AlliancePerformanceDTO(
                        e.getKey(),
                        e.getValue()
                ))
                .toList();
    }


    public List<PartyPerformanceDTO> getPartyPerformance() {

        List<Electionresult> results =
                electionResultRepository.findByElectionYear(2026);

        List<Electionresult> winners = getWinners(results);

        Map<String, Long> partySeats =
                winners.stream()
                        .collect(Collectors.groupingBy(
                                r -> r.getParty().getSmallName(),
                                Collectors.counting()
                        ));

        return partySeats.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(e -> new PartyPerformanceDTO(
                        e.getKey(),
                        e.getValue()
                ))
                .toList();
    }
    public List<AllianceVoteShareDTO> getAllianceVoteShare() {

        List<Electionresult> results =
                electionResultRepository.findByElectionYear(2026);

        long totalVotes = results.stream()
                .mapToLong(Electionresult::getVotes)
                .sum();

        Map<String, Long> allianceVotes = new HashMap<>();

        for (Electionresult result : results) {

            String category;

            String partyName = result.getParty().getSmallName();

            // NOTA
            if ("NOTA".equalsIgnoreCase(partyName)) {

                category = "NOTA";

            }

            // NTK contests alone
            else if ("NTK".equalsIgnoreCase(partyName)) {

                category = "NTK";

            }

            // Alliance parties
            else if (result.getAlliance() != null) {

                category = result.getAlliance().getName();

            }

            // Remaining parties & Independents
            else {

                category = "Others";

            }

            allianceVotes.merge(
                    category,
                    result.getVotes(),
                    Long::sum
            );
        }

        List<AllianceVoteShareDTO> response = new ArrayList<>();

        for (Map.Entry<String, Long> entry : allianceVotes.entrySet()) {

            double share = Math.round(
                    (entry.getValue() * 100.0 / totalVotes) * 100
            ) / 100.0;

            response.add(
                    new AllianceVoteShareDTO(
                            entry.getKey(),
                            entry.getValue(),
                            share
                    )
            );
        }

        response.sort(
                Comparator.comparingDouble(AllianceVoteShareDTO::getVoteShare)
                        .reversed()
        );

        return response;
    }

    public List<PartyVoteShareDTO> getPartyVoteShare() {

        List<Electionresult> results =
                electionResultRepository.findByElectionYear(2026);

        long totalVotes =
                results.stream()
                        .mapToLong(Electionresult::getVotes)
                        .sum();

        Set<String> majorParties = Set.of(
                "TVK",
                "DMK",
                "AIADMK",
                "PMK",
                "BJP",
                "VCK",
                "CPI",
                "CPI(M)",
                "IUML",
                "NTK"
        );

        Map<String, Long> partyVotes = new HashMap<>();

        for (Electionresult result : results) {

            String party = result.getParty().getSmallName();

            // Keep NOTA separate
            if ("NOTA".equalsIgnoreCase(party)) {

                partyVotes.merge("NOTA",
                        result.getVotes(),
                        Long::sum);

            }

            // Keep major parties separate
            else if (majorParties.contains(party)) {

                partyVotes.merge(party,
                        result.getVotes(),
                        Long::sum);

            }

            // Everything else goes to Others
            else {

                partyVotes.merge("Others",
                        result.getVotes(),
                        Long::sum);

            }
        }

        List<PartyVoteShareDTO> response = new ArrayList<>();

        for (Map.Entry<String, Long> entry : partyVotes.entrySet()) {

            double share = Math.round(
                    (entry.getValue() * 100.0 / totalVotes) * 100
            ) / 100.0;

            response.add(
                    new PartyVoteShareDTO(
                            entry.getKey(),
                            entry.getValue(),
                            share
                    )
            );
        }

        response.sort(
                Comparator.comparingDouble(PartyVoteShareDTO::getVoteShare)
                        .reversed()
        );

        return response;
    }

}
