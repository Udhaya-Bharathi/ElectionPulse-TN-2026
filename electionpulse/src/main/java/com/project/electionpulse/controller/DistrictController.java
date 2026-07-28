package com.project.electionpulse.controller;


import com.project.electionpulse.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/districts")
@CrossOrigin(origins = "http://localhost:5173")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping
    public List<String> getDistrictNames() {
        return districtService.getDistrictNames();
    }
}