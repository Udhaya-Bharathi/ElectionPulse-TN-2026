package com.project.electionpulse.controller;

import com.project.electionpulse.service.ElectionImportService;
import com.project.electionpulse.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/import")
public class ImportController {

    @Autowired
    private MasterDataService masterDataService;
    @Autowired
private ElectionImportService electionImportService;
 @PostMapping("/master")

 public String importMaster() {

     System.out.println("===== CONTROLLER HIT =====");

     masterDataService.importMasterData();

     return "Master data imported ";
 }
    @PostMapping("/election")
    public String importElection() {

        electionImportService.importElectionData();

        return "Election Imported";
    }
}
