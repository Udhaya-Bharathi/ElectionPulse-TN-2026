package com.project.electionpulse.service;


import com.project.electionpulse.entity.Party;
import com.project.electionpulse.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {
    @Autowired
    private PartyRepository partyrepo;

    public Party saveparty(Party party){
        return partyrepo.save(party);
    }
    public List<Party> getAllParties(){
        return partyrepo.findAll();
    }
    public Party getPartyById(Long id){
        return partyrepo.findById(id).orElse(null);
    }

    public Party updateParty(Long id, Party updatedParty) {

        Party existingParty = partyrepo.findById(id).orElse(null);

        if(existingParty == null){
            return null;
        }

        existingParty.setFullname(updatedParty.getFullname());
        existingParty.setShortname(updatedParty.getShortname());

        return partyrepo.save(existingParty);
    }

    public void deleteParty(Long id){
        partyrepo.deleteById(id);
    }
}
