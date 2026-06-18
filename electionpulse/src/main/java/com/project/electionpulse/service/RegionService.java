package com.project.electionpulse.service;

import com.project.electionpulse.entity.Election;
import com.project.electionpulse.entity.Region;
import com.project.electionpulse.repository.ElectionRepository;
import com.project.electionpulse.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegionService {
    @Autowired
    private RegionRepository regionrepo;

    public Region saveregion(Region region){
        return regionrepo.save(region);
    }



    public List<Region> getAllRegions(){
        return regionrepo.findAll();
    }

    public Region getRegionById(Long id){
        return regionrepo.findById(id).orElse(null);
    }

    public Region updateRegion(Long id,Region updatedRegion){
        Region existingRegion=regionrepo.findById(id).orElse(null);

        if(existingRegion==null){
            return null;
        }
        existingRegion.setName(updatedRegion.getName());

        return regionrepo.save(existingRegion);

    }

    public void deleteRegion(Long id){
        regionrepo.deleteById(id);
    }
}

