package com.Booysen31SA.services.teacher.users.appointed.impl;


import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
import com.Booysen31SA.repository.teacher.users.appointed.impl.AppointedRepositoryImpl;
import com.Booysen31SA.services.teacher.users.appointed.IAppointedService;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service("AppointedServiceImpl")
public class AppointedServiceImpl implements IAppointedService {
    private static AppointedServiceImpl service = null;
    private AppointedRepositoryImpl repository;

    public AppointedServiceImpl(){
        repository = AppointedRepositoryImpl.getRepository();
    }
    public static AppointedServiceImpl getService(){
        if(service == null){
            return new AppointedServiceImpl();
        }
        return service;
    }

    @Override
    public Set<DateAppointed> getAll() {
        return repository.getAll();
    }

    @Override
    public DateAppointed create(DateAppointed gender) {
        return repository.create(gender);
    }

    @Override
    public DateAppointed read(String integer) {
        return repository.read(integer);
    }

    @Override
    public DateAppointed update(DateAppointed gender) {
        return repository.update(gender);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}