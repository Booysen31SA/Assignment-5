package com.Booysen31SA.services.teacher.demography.impl;

import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.repository.teacher.demography.IRaceRepository;
import com.Booysen31SA.services.teacher.demography.IRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("RaceService")
public class RaceService implements IRaceService {

    private static RaceService service = null;
    @Autowired
    private IRaceRepository repository;

    public RaceService(){

    }
    public static RaceService getService(){
        if(service == null){
            return new RaceService();
        }
        return service;
    }

    @Override
    public Set<Race> getAll() {
        List<Race> list = (List<Race>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Race create(Race account) {
        return repository.save(account);
    }

    @Override
    public Race read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Race update(Race account) {
        return repository.save(account);
    }

    @Override
    public void delete(String integer) {
        repository.deleteById(integer);
    }

    public Race getByName(String genderDesc){
        Set<Race> genders = getAll();
        for (Race gender : genders) {
            if (gender.getRaceDescription().equalsIgnoreCase(genderDesc)) return gender;
        }
        return null;
    }

}
