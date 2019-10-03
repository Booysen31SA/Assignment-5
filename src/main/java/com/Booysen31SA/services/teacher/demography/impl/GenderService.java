package com.Booysen31SA.services.teacher.demography.impl;


import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.repository.teacher.demography.IGenderRepository;
import com.Booysen31SA.services.teacher.demography.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("GenderService")
public class GenderService implements IGenderService {

    private static GenderService service = null;
    @Autowired
    private IGenderRepository repository;

    public GenderService(){

    }
    public static GenderService getService(){
        if(service == null){
            return new GenderService();
        }
        return service;
    }

    @Override
    public Set<Gender> getAll() {

        List<Gender> list = (List<Gender>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Gender create(Gender appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public Gender read(String integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public Gender update(Gender appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }

    public Gender getByName(String genderDesc){
            Set<Gender> genders = getAll();
            for (Gender gender : genders) {
                if (gender.getGenderDescription().equalsIgnoreCase(genderDesc)) return gender;
            }
            return null;
        }
    }
