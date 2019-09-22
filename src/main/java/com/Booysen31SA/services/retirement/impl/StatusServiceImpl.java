package com.Booysen31SA.services.retirement.impl;

import com.Booysen31SA.domain.retirement.Status;
import com.Booysen31SA.repository.retirement.impl.StatusRepositoryImpl;
import com.Booysen31SA.services.retirement.IStatusService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service("StatusRetirementServiceImpl")
public class StatusServiceImpl implements IStatusService {

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
    public Status create(Status appointment) {
        return repository.create(appointment);
    }

    @Override
    public Status read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Status update(Status appointment) {
        return repository.update(appointment);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}
