package com.Booysen31SA.services.retirement.impl;

import com.Booysen31SA.domain.retirement.Retirement;
import com.Booysen31SA.repository.retirement.impl.RetirementRepositoryImpl;
import com.Booysen31SA.services.retirement.IRetirementService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("RetirementServiceImpl")
public class RetirementServiceImpl implements IRetirementService {

    private static RetirementServiceImpl service = null;
    private RetirementRepositoryImpl repository;

    public RetirementServiceImpl(){
        repository = RetirementRepositoryImpl.getRetirementRepository();
    }
    public static RetirementServiceImpl getService(){
        if(service == null){
            return new RetirementServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Retirement> getAll() {
        return repository.getAll();
    }

    @Override
    public Retirement create(Retirement appointment) {
        return repository.create(appointment);
    }

    @Override
    public Retirement read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Retirement update(Retirement appointment) {
        return repository.update(appointment);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}
