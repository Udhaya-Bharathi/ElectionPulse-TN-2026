//package com.project.electionpulse.config;
//
//import com.project.electionpulse.repository.ConstituencyRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//    private final ConstituencyRepository repository;
//
//    public DataLoader(ConstituencyRepository repository) {
//        this.repository = repository;
//    }
//    @Override
//    public void run(String[] args){
//        Constituency constituency =new Constituency();
//        constituency.setAcNumber(1);
//        constituency.setName("Gummidipoondi");
//        constituency.setDistrict("Tiruvallur");
//        constituency.setRegion("North");
//        constituency.setReserved("General");
//
//        repository.save(constituency);
//
//        System.out.println("Constituency Saved!");
//
//    }
//}
