//package com.Booysen31SA.repository.retirement.impl;
//
//import com.Booysen31SA.domain.retirement.Status;
//import com.Booysen31SA.repository.retirement.IStatusRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("StatusRetirementInMemory")
//public class StatusRepositoryImpl implements IStatusRepository {
//    private Set<Status> statusDB;
//    private static StatusRepositoryImpl StatusRepository = null;
//
//    private StatusRepositoryImpl() {
//        this.statusDB = new HashSet<>();
//    }
//
//    public static StatusRepositoryImpl getStatusRepository() {
//        if (StatusRepository == null) StatusRepository = new StatusRepositoryImpl();
//        return StatusRepository;
//    }
//    @Override
//    public Status create(Status status) {
//        if(read(status.getPersal_Number()) == null){
//            statusDB.add(status);
//        }
//        return status;
//    }
//
//    @Override
//    public Status read(String s) {
//        return statusDB.stream().filter(status -> status.getPersal_Number().equalsIgnoreCase(s)).findAny().orElse(null);
//
//    }
//
//    @Override
//    public Status update(Status status) {
//        if(read(status.getPersal_Number()) != null){
//            delete(status.getPersal_Number());
//            create(status);
//        }
//        return status;
//    }
//
//    @Override
//    public void delete(String s) {
//        Status appointment = read(s);
//        if(appointment != null){
//            statusDB.remove(appointment);
//        }
//    }
//
//    @Override
//    public Set<Status> getAll() {
//        return statusDB;
//    }
//}
