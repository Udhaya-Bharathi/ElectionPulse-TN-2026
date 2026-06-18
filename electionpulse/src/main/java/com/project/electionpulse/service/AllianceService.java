package com.project.electionpulse.service;

import com.project.electionpulse.entity.Alliance;
import com.project.electionpulse.repository.AllianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllianceService {

    @Autowired
    private AllianceRepository alliancerepo;

    public Alliance savealliance(Alliance alliance){
        return alliancerepo.save(alliance);
    }

    public List<Alliance> getallAlliance(){
        return alliancerepo.findAll();
    }

}
