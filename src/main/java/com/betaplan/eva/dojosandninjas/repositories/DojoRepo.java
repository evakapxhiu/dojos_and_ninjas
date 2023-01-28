package com.betaplan.eva.dojosandninjas.repositories;

import com.betaplan.eva.dojosandninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DojoRepo extends CrudRepository<Dojo,Long> {
    List<Dojo> findAll();
}
