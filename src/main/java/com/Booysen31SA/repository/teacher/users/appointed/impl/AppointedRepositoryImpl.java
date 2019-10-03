//package com.Booysen31SA.repository.teacher.users.appointed.impl;
//
//import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
//import com.Booysen31SA.repository.teacher.users.appointed.IAppointedRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("AppointedInMemory")
//public class AppointedRepositoryImpl implements IAppointedRepository {
//    private static AppointedRepositoryImpl DateAppointedRepository = null;
//    Set<DateAppointed> DateAppointeds;
//    public AppointedRepositoryImpl(){
//        DateAppointeds = new HashSet<>();
//    }
//
//    public static AppointedRepositoryImpl getRepository(){
//        if(DateAppointedRepository == null){
//            return new AppointedRepositoryImpl();
//        }
//        return DateAppointedRepository;
//    }
//
//    @Override
//    public Set<DateAppointed> getAll() {
//        return DateAppointeds;
//    }
//
//    @Override
//    public DateAppointed create(DateAppointed DateAppointed) {
//        if(read(DateAppointed.getPersal_Number()) == null){
//            DateAppointeds.add(DateAppointed);
//        }
//        return DateAppointed;
//    }
//
//    @Override
//    public DateAppointed read(String integer) {
//        return DateAppointeds.stream().filter(DateAppointed -> DateAppointed.getPersal_Number().equalsIgnoreCase(integer)).findAny().orElse(null);
//    }
//
//    @Override
//    public DateAppointed update(DateAppointed DateAppointed) {
//        if(read(DateAppointed.getPersal_Number()) != null){
//            delete(DateAppointed.getPersal_Number());
//            create(DateAppointed);
//        }
//        return DateAppointed;
//    }
//
//    @Override
//    public void delete(String integer) {
//        if(read(integer) != null){
//            DateAppointed g = read(integer);
//            DateAppointeds.remove(g);
//        }
//    }
//}
