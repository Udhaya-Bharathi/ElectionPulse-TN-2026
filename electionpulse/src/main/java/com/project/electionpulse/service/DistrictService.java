package com.project.electionpulse.service;

import com.project.electionpulse.entity.Constituency;
import com.project.electionpulse.entity.District;
import com.project.electionpulse.repository.ConstituencyRepository;
import com.project.electionpulse.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtrepo;

    private District savefn(District district){
        return districtrepo.save(district);
    }



    public List<District> getAllConstituencies(){
        return districtrepo.findAll();
    }


}
