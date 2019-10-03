package com.Booysen31SA.services.appointment.impl;

import com.Booysen31SA.domain.appointment.DateAndTime;
import com.Booysen31SA.repository.appointment.IDateAndTimeRepository;
import com.Booysen31SA.services.appointment.IDateAndTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("DateAndTimeServiceImpl")
public class DateAndTimeServiceImpl implements IDateAndTimeService {

    private static DateAndTimeServiceImpl service = null;
    @Autowired
    private IDateAndTimeRepository repository;

    public DateAndTimeServiceImpl(){
    }
    public static DateAndTimeServiceImpl getService(){
        if(service == null){
            return new DateAndTimeServiceImpl();
        }
        return service;
    }

    @Override
    public Set<DateAndTime> getAll() {
        List<DateAndTime> list = (List<DateAndTime>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public DateAndTime create(DateAndTime appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public DateAndTime read(String integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public DateAndTime update(DateAndTime appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public void delete(String integer) {
       this.repository.deleteById(integer);
    }
}
