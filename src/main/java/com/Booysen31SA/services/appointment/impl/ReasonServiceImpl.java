package com.Booysen31SA.services.appointment.impl;

import com.Booysen31SA.domain.appointment.Reason;
import com.Booysen31SA.repository.appointment.IReasonRepository;
import com.Booysen31SA.services.appointment.IReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("ReasonServiceImpl")
public class ReasonServiceImpl implements IReasonService {

    private static ReasonServiceImpl service = null;
    @Autowired
    private IReasonRepository repository;

    public ReasonServiceImpl(){

    }
    public static ReasonServiceImpl getService(){
        if(service == null){
            return new ReasonServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Reason> getAll() {
        List<Reason> list = (List<Reason>) repository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public Reason create(Reason appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public Reason read(String integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public Reason update(Reason appointment) {
        return repository.save(appointment);
    }

    @Override
    public void delete(String integer) {
        repository.deleteById(integer);
    }
}
