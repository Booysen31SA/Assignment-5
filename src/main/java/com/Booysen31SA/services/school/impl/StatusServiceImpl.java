package com.Booysen31SA.services.school.impl;


import com.Booysen31SA.domain.school.Status;
import com.Booysen31SA.repository.school.impl.StatusRepositoryImpl;
import com.Booysen31SA.services.school.IStatus;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("StatusSchoolServiceImpl")
public class StatusServiceImpl implements IStatus {


    private static StatusServiceImpl service = null;
    private StatusRepositoryImpl repository;

    public StatusServiceImpl(){
        repository = StatusRepositoryImpl.getStatusRepository();
    }
    public static StatusServiceImpl getService(){
        if(service == null){
            return new StatusServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Status> getAll() {
        return repository.getAll();
    }

    @Override
    public Status create(Status status) {
        return repository.create(status);
    }

    @Override
    public Status read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Status update(Status status) {
        return repository.update(status);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}
