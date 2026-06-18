package com.project.electionpulse.controller;


import com.project.electionpulse.entity.Party;
import com.project.electionpulse.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/parties")
public class PartyController {
    @Autowired
    private PartyService partyservice;


    @PostMapping
    public Party createparty(@RequestBody Party party){
        return partyservice.saveparty(party);
    }

    @GetMapping
    public List<Party>getAllParties(){
        return partyservice.getAllParties();
    }

    @GetMapping("/{id}")
    public Party getPartyById(@PathVariable Long id) {
        return partyservice.getPartyById(id);
    }

    @PutMapping("/{id}")//UPDATES PARTY
    public Party updateParty(@PathVariable Long id,
                             @RequestBody Party party){

        return partyservice.updateParty(id, party);
    }

    @DeleteMapping("/{id}")
    public void deleteParty(@PathVariable Long id){
        partyservice.deleteParty(id);
    }
}
