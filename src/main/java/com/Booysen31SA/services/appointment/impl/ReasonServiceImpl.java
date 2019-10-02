package com.Booysen31SA.services.appointment.impl;

import com.Booysen31SA.domain.appointment.Reason;
import com.Booysen31SA.repository.appointment.IReasonRepository;
import com.Booysen31SA.repository.appointment.impl.ReasonRepositoryImpl;
import com.Booysen31SA.services.appointment.IReasonService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ReasonServiceImpl")
public class ReasonServiceImpl implements IReasonService {

    private static ReasonServiceImpl service = null;
    private IReasonRepository repository;

    public ReasonServiceImpl(){
        repository = ReasonRepositoryImpl.getReasonRepository();
    }
    public static ReasonServiceImpl getService(){
        if(service == null){
            return new ReasonServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Reason> getAll() {
        return repository.getAll();
    }

    @Override
    public Reason create(Reason appointment) {
        return repository.create(appointment);
    }

    @Override
    public Reason read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Reason update(Reason appointment) {
        return repository.update(appointment);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}
