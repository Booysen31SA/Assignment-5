package com.Booysen31SA.services.school.impl;


import com.Booysen31SA.domain.school.Status;
import com.Booysen31SA.repository.school.IStatus;
import com.Booysen31SA.services.school.IStatusRetirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("StatusSchoolServiceImpl")
public class StatusRetirementServiceImpl implements IStatusRetirement {


    private static StatusRetirementServiceImpl service = null;
    @Autowired
    private IStatus repository;

    public StatusRetirementServiceImpl(){

    }
    public static StatusRetirementServiceImpl getService(){
        if(service == null){
            return new StatusRetirementServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Status> getAll() {
        List<Status> list = (List<Status>) this.repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Status create(Status appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public Status read(String integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public Status update(Status appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }
}
