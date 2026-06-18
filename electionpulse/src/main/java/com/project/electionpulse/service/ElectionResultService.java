package com.project.electionpulse.service;

import com.project.electionpulse.entity.Election;
import com.project.electionpulse.entity.Electionresult;
import com.project.electionpulse.repository.ElectionRepository;
import com.project.electionpulse.repository.ElectionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ElectionResultService {
    @Autowired
    private ElectionResultRepository electionresultrepo;

    private Electionresult savefn(Electionresult electionresult){
        return electionresultrepo.save(electionresult);
    }



    public List<Electionresult> getAllelectionresult(){
        return electionresultrepo.findAll();
    }

}
