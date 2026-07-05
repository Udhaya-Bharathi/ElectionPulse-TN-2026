package com.project.electionpulse.service;

import com.opencsv.CSVReader;
import com.project.electionpulse.entity.*;
import com.project.electionpulse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@Service
public class ElectionImportService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private AllianceRepository allianceRepository;

    @Autowired
    private ConstituencyRepository constituencyRepository;

    @Autowired
    private ElectionResultRepository electionResultRepository;

    public void importElectionData() {

        try {

            Resource resource =
                    resourceLoader.getResource("classpath:data/tn_2026_results.csv");

            Reader reader = new InputStreamReader(resource.getInputStream());

            CSVReader csvReader = new CSVReader(reader);

            List<String[]> rows = csvReader.readAll();

            Integer year = 2026;

            Optional<Election> optionalElection =
                    electionRepository.findByYear(year);

            Election election;

            if (optionalElection.isPresent()) {

                election = optionalElection.get();

            } else {

                election = new Election();

                election.setYear(2026);
                election.setType("Assembly");


                election=electionRepository.save(election);

            }

            for (int i = 1; i < rows.size(); i++) {

                String[] row = rows.get(i);

                String constituencyName = row[0].trim();

                Integer acNumber =
                        Integer.parseInt(row[1]);

                String candidateName = row[2].trim();

                String partyName = row[3].trim();

                Long votes =
                        Long.parseLong(row[4]);

                Optional<Party> optionalParty =
                        partyRepository.findBySmallName(partyName);

                Party party;

                if (optionalParty.isPresent()) {

                    party = optionalParty.get();


                } else {

                    party = new Party();

                    party.setSmallName(partyName);
                    party.setFullName(partyName);

                    partyRepository.save(party);

                }

                String allianceName = getAllianceName(partyName);

                Optional<Alliance> optionalAlliance =
                        allianceRepository.findByName(allianceName);

                Alliance alliance;

                if(optionalAlliance.isPresent()){

                    alliance = optionalAlliance.get();

                }
                else{

                    alliance = new Alliance();

                    alliance.setName(allianceName);
                    alliance.setFullname(allianceName);

                    allianceRepository.save(alliance);

                }

                Optional<Constituency> optionalConstituency =
                        constituencyRepository.findByAcNumber(acNumber);

                if (optionalConstituency.isEmpty()) {

                    continue;

                }

                Constituency constituency =
                        optionalConstituency.get();
                Electionresult result = new Electionresult();

                result.setElection(election);

                result.setConstituency(constituency);

                result.setParty(party);

                result.setAlliance(alliance);

                result.setCandidateName(candidateName);

                result.setVotes(votes);


                Electionresult saved = electionResultRepository.save(result);


                // Alliance comes here

                // ElectionResult comes here

            }

            System.out.println("2026 Import Completed");

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }
    private String getAllianceName(String party) {

        switch (party) {

            // SPA
            case "DMK":
            case "INC":
            case "MDMK":
            case "KMDK":
            case "MMK":
            case "MJK":
            case "MTP":
            case "SDPI":
            case "TDK":
            case "DMDK":
            case "VCK":
            case "CPI":
            case "CPM":
            case "IUML":
                return "SPA";

            // NDA
            case "AIADMK":
            case "BJP":
            case "PMK":
            case "AMMK":
            case "TMC":
            case "IJK":
            case "PBK":
            case "PNK":
            case "STMK":
            case "TMBSP":
            case "SIFB":
            case "TMMK":
                return "NDA";

            // TVK
            case "TVK":
                return "TVK";

            // NTK
            case "NTK":
                return "NTK";

            // NOTA
            case "NOTA":
                return "NOTA";

            default:
                return "Independent";
        }
    }


}