package com.project.electionpulse.service;
//
import com.project.electionpulse.entity.Constituency;
import com.project.electionpulse.repository.ConstituencyRepository;
import com.project.electionpulse.entity.Constituency;
import com.project.electionpulse.repository.ConstituencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConstituencyService {

    @Autowired
    private ConstituencyRepository constituencyrepo;

    public Constituency saveconstituency(Constituency constituency) {
        return constituencyrepo.save(constituency);
    }


    public List<Constituency> getAllConstituencies() {
        return constituencyrepo.findAll();
    }


    public Constituency getConstituencyById(Long id) {
        return constituencyrepo.findById(id).orElse(null);
    }

    public Constituency updateConstituency(Long id, Constituency updatedConstituency) {

        Constituency existingConstituency = constituencyrepo.findById(id).orElse(null);

        if (existingConstituency == null) {
            return null;
        }

        existingConstituency.setName(updatedConstituency.getName());


        return constituencyrepo.save(existingConstituency);
    }

    public void deleteConstituency(Long id) {
        constituencyrepo.deleteById(id);
    }

}
