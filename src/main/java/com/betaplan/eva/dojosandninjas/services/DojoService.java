package com.betaplan.eva.dojosandninjas.services;

import com.betaplan.eva.dojosandninjas.models.Dojo;
import com.betaplan.eva.dojosandninjas.models.Ninja;
import com.betaplan.eva.dojosandninjas.repositories.DojoRepo;
import com.betaplan.eva.dojosandninjas.repositories.NinjaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
    @Autowired
    private DojoRepo dojoRepo;
    @Autowired
    private NinjaRepo ninjaRepo;

    public List<Dojo> findDojos(){
        return dojoRepo.findAll();
    }
    public Dojo create(Dojo dojo){
        return dojoRepo.save(dojo);
    }

    public Dojo getDojoID(Long id){
        return dojoRepo.findById(id).orElse(null);

    }
    public Ninja createNinja(Ninja ninja){return ninjaRepo.save(ninja);}
}
