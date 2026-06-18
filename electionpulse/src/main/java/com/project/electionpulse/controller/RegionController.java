package com.project.electionpulse.controller;


import com.project.electionpulse.entity.Party;
import com.project.electionpulse.entity.Region;
import com.project.electionpulse.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private RegionService regionservice;


    @PostMapping
    public Region createregion(@RequestBody Region region) {
        return regionservice.saveregion(region);

    }


    @GetMapping
    public List<Region> getAllRegions(){
        return regionservice.getAllRegions();
    }

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable Long id) {
        return regionservice.getRegionById(id);
    }

    @PutMapping("/{id}")//UPDATES PARTY
    public Region updateRegion(@PathVariable Long id,
                             @RequestBody Region region){

        return regionservice.updateRegion(id, region);
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable Long id){
        regionservice.deleteRegion(id);
    }
}


