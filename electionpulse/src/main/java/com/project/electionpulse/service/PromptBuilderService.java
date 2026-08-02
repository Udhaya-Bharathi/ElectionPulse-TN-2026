package com.project.electionpulse.service;

import com.project.electionpulse.dto.*;

import org.springframework.stereotype.Service;

@Service
public class PromptBuilderService {

    public String buildDistrictPrompt(DistrictPerformanceDTO dto) {

        StringBuilder prompt = new StringBuilder();

        prompt.append("""
                You are an expert political analyst.

                Analyze ONLY the following election data.
                Do NOT use outside knowledge.
                Do NOT invent facts.
                Give a professional report in bullet points.

                ==========================
                DISTRICT SUMMARY
                ==========================
                """);

        prompt.append("\nDistrict : ").append(dto.getDistrict());

        prompt.append("\nTotal Seats : ").append(dto.getTotalSeats());

        prompt.append("\nSeat Leader : ").append(dto.getSeatLeader());

        prompt.append("\nSeat Leader Seats : ").append(dto.getSeatLeaderSeats());

        prompt.append("\nVote Leader : ").append(dto.getVoteLeader());

        prompt.append("\nVote Leader Vote Share : ")
                .append(dto.getVoteLeaderShare())
                .append("%");

        prompt.append("\nAverage Victory Margin : ")
                .append(dto.getAverageVictoryMargin());

        prompt.append("\n\n==========================");
        prompt.append("\nALLIANCE BREAKDOWN");
        prompt.append("\n==========================");

        for (DistrictAllianceDTO alliance : dto.getAllianceBreakdown()) {

            prompt.append("\n")
                    .append(alliance.getAlliance())
                    .append(" -> Seats : ")
                    .append(alliance.getSeats())
                    .append(", Vote Share : ")
                    .append(alliance.getVoteShare())
                    .append("%");
        }

        prompt.append("\n\n==========================");
        prompt.append("\nPARTY BREAKDOWN");
        prompt.append("\n==========================");

        for (DistrictPartyDTO party : dto.getPartyBreakdown()) {

            prompt.append("\n")
                    .append(party.getParty())
                    .append(" -> Seats : ")
                    .append(party.getSeats())
                    .append(", Vote Share : ")
                    .append(party.getVoteShare())
                    .append("%");
        }

        if(dto.getLargestVictory()!=null){

            prompt.append("\n\nLargest Victory");

            prompt.append("\n")
                    .append(dto.getLargestVictory().getConstituency())
                    .append(" : ")
                    .append(dto.getLargestVictory().getWinner())
                    .append(" (")
                    .append(dto.getLargestVictory().getWinnerParty())
                    .append(")");

        }

        if(dto.getClosestContest()!=null){

            prompt.append("\n\nClosest Contest");

            prompt.append("\n")
                    .append(dto.getClosestContest().getConstituency())
                    .append(" : Margin ")
                    .append(dto.getClosestContest().getMarginVotes());

        }

        prompt.append("""

                You are ElectionPulse AI, a professional political data analyst.
                
                                   Rules:
                                   - Use ONLY the supplied election statistics.
                                   - Never invent facts.
                                   - Mention seat performance.
                                   - Mention vote share performance.
                                   - Mention major competitors.
                                   - Mention notable observations.
                                   - Mention electoral efficiency if applicable.
                                   - Mention largest victory and closest contest when available.
                                   - End with a one-line conclusion.
                """);

        return prompt.toString();

    }

}