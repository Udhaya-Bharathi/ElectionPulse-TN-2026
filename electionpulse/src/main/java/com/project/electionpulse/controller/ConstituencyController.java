package com.project.electionpulse.controller;


import com.project.electionpulse.entity.Constituency;

import com.project.electionpulse.service.ConstituencyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/constituencies")
public class ConstituencyController {
    @Autowired
    private ConstituencyService constituencyservice;


    @PostMapping
    public  Constituency createconstituency(@RequestBody Constituency Constituency){
        return constituencyservice.saveconstituency(Constituency);
    }

    @GetMapping
    public List<Constituency>getAllConstituencies(){
        return constituencyservice.getAllConstituencies();
    }

    @GetMapping("/{id}")
    public Constituency ConstituencyById(@PathVariable Long id) {
        return constituencyservice.getConstituencyById(id);
    }

    @PutMapping("/{id}")//UPDATES Constituency
    public Constituency updateConstituency(@PathVariable Long id,
                             @RequestBody Constituency Constituency){

        return constituencyservice.updateConstituency(id, Constituency);
    }

    @DeleteMapping("/{id}")
    public void deleteConstituency(@PathVariable Long id){
        constituencyservice.deleteConstituency(id);
    }
}

