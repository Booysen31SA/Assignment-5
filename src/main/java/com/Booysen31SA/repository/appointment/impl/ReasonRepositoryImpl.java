package com.Booysen31SA.repository.appointment.impl;

import com.Booysen31SA.domain.appointment.Reason;
import com.Booysen31SA.repository.appointment.IReasonRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ReasonInMemory")
public class ReasonRepositoryImpl implements IReasonRepository {

    private Set<Reason> reason;
    private static ReasonRepositoryImpl ReasonRepository = null;

    private ReasonRepositoryImpl() {
        this.reason = new HashSet<>();
    }

    public static ReasonRepositoryImpl getReasonRepository() {
        if (ReasonRepository == null) ReasonRepository = new ReasonRepositoryImpl();
        return ReasonRepository;
    }
    @Override
    public Reason create(Reason dateAndTime) {
        if(read(dateAndTime.getPersal_Number()) == null){
            reason.add(dateAndTime);
        }
        return dateAndTime;
    }

    @Override
    public Reason read(String s) {
        return reason.stream().filter(dateAndTime -> dateAndTime.getPersal_Number().equalsIgnoreCase(s)).findAny().orElse(null);

    }

    @Override
    public Reason update(Reason dateAndTime) {
        if(read(dateAndTime.getPersal_Number()) != null){
            delete(dateAndTime.getPersal_Number());
            create(dateAndTime);
        }
        return dateAndTime;
    }

    @Override
    public void delete(String s) {
        Reason appointment = read(s);
        if(appointment != null){
            reason.remove(appointment);
        }
    }

    @Override
    public Set<Reason> getAll() {
        return reason;
    }
}
