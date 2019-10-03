//package com.Booysen31SA.repository.teacher.demography.impl;
//
//import com.Booysen31SA.domain.teacher.demography.Gender;
//import com.Booysen31SA.repository.teacher.demography.IGenderRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Repository("GenderInMemory")
//public class GenderRepository implements IGenderRepository {
//
//    private static GenderRepository genderRepository = null;
//    Set<Gender> genders;
//    public GenderRepository(){
//        genders = new HashSet<Gender>();
//    }
//
//    public static GenderRepository getRepository(){
//        if(genderRepository == null){
//            return new GenderRepository();
//        }
//        return genderRepository;
//    }
//
//    @Override
//    public Set<Gender> getAll() {
//        return genders;
//    }
//
//    @Override
//    public Gender create(Gender gender) {
//        if(read(gender.getGenderDescription()) == null){
//            genders.add(gender);
//        }
//        return gender;
//    }
//
//    @Override
//    public Gender read(String integer) {
//        return genders.stream().filter(gender -> gender.getGenderDescription().equalsIgnoreCase(integer)).findAny().orElse(null);
//    }
//
//    @Override
//    public Gender update(Gender gender) {
//        if(read(gender.getGenderDescription()) != null){
//            delete(gender.getGenderId());
//            create(gender);
//        }
//        return gender;
//    }
//
//    @Override
//    public void delete(String integer) {
//        if(read(integer) != null){
//            Gender g = read(integer);
//            genders.remove(g.getGenderId());
//        }
//    }
//}
