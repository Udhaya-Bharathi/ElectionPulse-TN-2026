package com.project.electionpulse.service;

import com.opencsv.CSVReader;
import com.project.electionpulse.entity.Constituency;
import com.project.electionpulse.entity.District;
import com.project.electionpulse.entity.Region;
import com.project.electionpulse.repository.ConstituencyRepository;
import com.project.electionpulse.repository.DistrictRepository;
import com.project.electionpulse.repository.RegionRepository;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MasterDataService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ConstituencyRepository constituencyRepository;


    public void importMasterData(){
        try {

            Resource resource = resourceLoader.getResource("classpath:data/constituency_master.csv");
                    Reader reader=new InputStreamReader(resource.getInputStream());
                    CSVReader csvReader=new CSVReader(reader);

            System.out.println("Import Started");

            List<String[]> rows = csvReader.readAll();

            System.out.println("Rows = " + rows.size());



  for(int i=1;i<rows.size();i++) {
      String[] row = rows.get(i);
      //System.out.println(Arrays.toString(row));
      Integer acNumber = Integer.parseInt(row[0]);
      String constituencyName = row[1].trim();
      String districtName = row[2].trim();
      String regionName = row[3].trim();
      String reserved = row[4].trim();
      String lokSabha = row[5].trim();
      Optional<Region> optionalRegion =
              regionRepository.findByName(regionName);
      Region region;
      if (optionalRegion.isPresent()) {//not empty
          region = optionalRegion.get();
          System.out.println(region);
      } else {
          region = new Region();
          region.setName(regionName);
          regionRepository.save(region);
          System.out.println("Created Region : " + regionName);
      }



          Optional<District> optionalDistrict =
                  districtRepository.findByName(districtName);
          District district;
          if (optionalDistrict.isPresent()) {//not empty
              district = optionalDistrict.get();
              System.out.println(district);
          } else {
              district = new District();
              district.setName(districtName);
              district.setRegion(region);
              districtRepository.save(district);
              System.out.println("Created district : " + districtName);
          }
          Optional<Constituency> optionalConstituency=constituencyRepository.findByAcNumber(acNumber);
      Constituency constituency;
      if(optionalConstituency.isPresent()){
          constituency=optionalConstituency.get();
          System.out.println(constituency);
      }
      else{
          constituency=new Constituency();
          constituency.setAcNumber(acNumber);
          constituency.setName(constituencyName);
          constituency.setSeatCategory(reserved);
          constituency.setDistrict(district);
          constituency.setLokSabhaConstituency(lokSabha);

          constituencyRepository.save(constituency);
      }

  }
        }
        catch (Exception e){

            e.printStackTrace();

        }
    }
}
