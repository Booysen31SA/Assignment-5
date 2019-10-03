//package com.Booysen31SA.repository.teacher.demography.impl;
//
//import com.Booysen31SA.domain.teacher.demography.Race;
//import com.Booysen31SA.repository.teacher.demography.IRaceRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("RaceInMemory")
//public class RaceRepository implements IRaceRepository {
//
//    private static RaceRepository repository = null;
//    private Set<Race> races;
//
//    public RaceRepository(){
//        races = new HashSet<Race>();
//    }
//    public static RaceRepository raceRepository(){
//        if(repository == null){
//            return new RaceRepository();
//        }
//        return repository;
//    }
//
//    @Override
//    public Set<Race> getAll() {
//        return races;
//    }
//
//    @Override
//    public Race create(Race race) {
//        if(read(race.getRaceDescription()) == null){
//            races.add(race);
//        }
//        return race;
//    }
//
//    @Override
//    public Race read(String integer) {
//        return races.stream().filter(race -> race.getRaceDescription().equalsIgnoreCase(integer)).findAny().orElse(null);
//    }
//
//    @Override
//    public Race update(Race race) {
//        if(read(race.getRaceDescription()) != null){
//            delete(race.getRaceId());
//            create(race);
//        }
//        return race;
//    }
//
//    @Override
//    public void delete(String integer) {
//      Race race = read(integer);
//      if(race != null){
//          races.remove(race.getRaceId());
//      }
//    }
//}
