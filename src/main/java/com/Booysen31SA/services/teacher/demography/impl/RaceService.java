package com.Booysen31SA.services.teacher.demography.impl;

import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.repository.teacher.demography.impl.RaceRepository;
import com.Booysen31SA.services.teacher.demography.IRaceService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service("RaceService")
public class RaceService implements IRaceService {

    private static RaceService service = null;
    private RaceRepository repository;

    public RaceService(){
        repository = RaceRepository.raceRepository();
    }
    public static RaceService getService(){
        if(service == null){
            return new RaceService();
        }
        return service;
    }

    @Override
    public Set<Race> getAll() {
        return repository.getAll();
    }

    @Override
    public Race create(Race gender) {
        return repository.create(gender);
    }

    @Override
    public Race read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Race update(Race gender) {
        return repository.update(gender);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }

    public Race getByName(String raceDesc){
        return repository.getAll()
                .stream().filter(race -> race.getRaceDescription().equalsIgnoreCase(raceDesc))
                .findAny()
                .orElse(null);
    }
}
