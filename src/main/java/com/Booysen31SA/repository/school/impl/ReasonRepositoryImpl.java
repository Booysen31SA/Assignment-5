package com.Booysen31SA.repository.school.impl;

import com.Booysen31SA.domain.school.Reason;
import com.Booysen31SA.repository.school.IReason;

import java.util.HashSet;
import java.util.Set;

public class ReasonRepositoryImpl /*implements IReason*/ {
//    private Set<Reason> reasonDB;
//    private static ReasonRepositoryImpl ReasonRepository = null;
//
//    private ReasonRepositoryImpl() {
//        this.reasonDB = new HashSet<>();
//    }
//
//    public static ReasonRepositoryImpl getReasonRepository() {
//        if (ReasonRepository == null) ReasonRepository = new ReasonRepositoryImpl();
//        return ReasonRepository;
//    }
//    @Override
//    public Reason create(Reason reason) {
//        if(read(reason.getPersal_Number()) == null){
//            reasonDB.add(reason);
//        }
//        return reason;
//    }
//
//    @Override
//    public Reason read(String s) {
//        return reasonDB.stream().filter(reason -> reason.getPersal_Number() == s).findAny().orElse(null);
//
//    }
//
//    @Override
//    public Reason update(Reason reason) {
//        if(read(reason.getPersal_Number()) != null){
//            delete(reason.getPersal_Number());
//            create(reason);
//        }
//        return reason;
//    }
//
//    @Override
//    public void delete(String s) {
//        Reason appointment = read(s);
//        if(appointment != null){
//            reasonDB.remove(appointment);
//        }
//    }
//
//    @Override
//    public Set<Reason> getAll() {
//        return reasonDB;
//    }
}
