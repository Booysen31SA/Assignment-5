package com.Booysen31SA.services.retirement.impl;

import com.Booysen31SA.domain.retirement.Retirement;
import com.Booysen31SA.repository.retirement.IRetirementRepository;
import com.Booysen31SA.services.retirement.IRetirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("RetirementServiceImpl")
public class RetirementServiceImpl implements IRetirementService {

    private static RetirementServiceImpl service = null;
    @Autowired
    private IRetirementRepository repository;

    public RetirementServiceImpl(){

    }
    public static RetirementServiceImpl getService(){
        if(service == null){
            return new RetirementServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Retirement> getAll()  {List<Retirement> list = (List<Retirement>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Retirement create(Retirement appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public Retirement read(String integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public Retirement update(Retirement appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public void delete(String integer) {
        this.repository.deleteById(integer);
    }
}
