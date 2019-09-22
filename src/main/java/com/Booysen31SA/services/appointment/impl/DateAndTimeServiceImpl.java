package com.Booysen31SA.services.appointment.impl;

import com.Booysen31SA.domain.appointment.DateAndTime;
import com.Booysen31SA.repository.appointment.impl.DateAndTimeRepositoryImpl;
import com.Booysen31SA.services.appointment.IDateAndTimeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("DateAndTimeServiceImpl")
public class DateAndTimeServiceImpl implements IDateAndTimeService {

    private static DateAndTimeServiceImpl service = null;
    private DateAndTimeRepositoryImpl repository;

    public DateAndTimeServiceImpl(){
        repository = DateAndTimeRepositoryImpl.getDateAndTimeRepository();
    }
    public static DateAndTimeServiceImpl getService(){
        if(service == null){
            return new DateAndTimeServiceImpl();
        }
        return service;
    }

    @Override
    public Set<DateAndTime> getAll() {
        return repository.getAll();
    }

    @Override
    public DateAndTime create(DateAndTime appointment) {
        return repository.create(appointment);
    }

    @Override
    public DateAndTime read(String integer) {
        return repository.read(integer);
    }

    @Override
    public DateAndTime update(DateAndTime appointment) {
        return repository.update(appointment);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}
