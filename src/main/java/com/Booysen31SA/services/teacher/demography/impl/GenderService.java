package com.Booysen31SA.services.teacher.demography.impl;


import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.repository.teacher.demography.impl.GenderRepository;
import com.Booysen31SA.services.teacher.demography.IGenderService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("GenderService")
public class GenderService implements IGenderService {

    private static GenderService service = null;
    private GenderRepository repository;

    public GenderService(){
        repository = GenderRepository.getRepository();
    }
    public static GenderService getService(){
        if(service == null){
            return new GenderService();
        }
        return service;
    }

    @Override
    public Set<Gender> getAll() {
        return repository.getAll();
    }

    @Override
    public Gender create(Gender gender) {
        return repository.create(gender);
    }

    @Override
    public Gender read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Gender update(Gender gender) {
        return repository.update(gender);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }

    public Gender getByName(String genderDesc){
        return repository.getAll()
                .stream().filter(gender -> gender.getGenderDescription() == genderDesc)
                .findAny()
                .orElse(null);
    }
}
