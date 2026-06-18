package com.project.electionpulse.service;

import com.project.electionpulse.entity.Election;
import com.project.electionpulse.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ElectionService {
    @Autowired
    private ElectionRepository electionrepo;

    private Election savefn(Election election){
        return electionrepo.save(election);
    }



    public List<Election> getAllelections(){
        return electionrepo.findAll();
    }
}
