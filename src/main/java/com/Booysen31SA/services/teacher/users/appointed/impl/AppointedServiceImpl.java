package com.Booysen31SA.services.teacher.users.appointed.impl;


import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
import com.Booysen31SA.repository.teacher.users.appointed.IAppointedRepository;
import com.Booysen31SA.services.teacher.users.appointed.IAppointedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("AppointedServiceImpl")
public class AppointedServiceImpl implements IAppointedService {
    private static AppointedServiceImpl service = null;
    @Autowired
    private IAppointedRepository repository;

    public AppointedServiceImpl(){

    }
    public static AppointedServiceImpl getService(){
        if(service == null){
            return new AppointedServiceImpl();
        }
        return service;
    }

    @Override
    public Set<DateAppointed> getAll() {
        List<DateAppointed> list = (List<DateAppointed>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public DateAppointed create(DateAppointed account) {
        return repository.save(account);
    }

    @Override
    public DateAppointed read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public DateAppointed update(DateAppointed account) {
        return repository.save(account);
    }

    @Override
    public void delete(String integer) {
        repository.deleteById(integer);
    }
}