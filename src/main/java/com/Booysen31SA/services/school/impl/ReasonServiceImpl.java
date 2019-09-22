//package com.Booysen31SA.services.school.impl;
//
//import com.Booysen31SA.domain.school.Reason;
//import com.Booysen31SA.repository.school.impl.ReasonRepositoryImpl;
//import com.Booysen31SA.services.school.IReason;
//
//import java.util.Set;
//
//public class ReasonServiceImpl implements IReason {
//
//    private static ReasonServiceImpl service = null;
//    private ReasonRepositoryImpl repository;
//
//    public ReasonServiceImpl(){
//        repository = ReasonRepositoryImpl.getRepository();
//    }
//    public static ReasonServiceImpl getService(){
//        if(service == null){
//            return new ReasonServiceImpl();
//        }
//        return service;
//    }
//
//    @Override
//    public Set<Reason> getAll() {
//        return null;
//    }
//
//    @Override
//    public Reason create(Reason appointment) {
//        return repository.create(appointment);
//    }
//
//    @Override
//    public Reason read(String integer) {
//        return repository.read(integer);
//    }
//
//    @Override
//    public Reason update(Reason appointment) {
//        return repository.update(appointment);
//    }
//
//    @Override
//    public void delete(String integer) {
//        repository.delete(integer);
//    }
//}