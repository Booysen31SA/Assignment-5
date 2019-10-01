package com.Booysen31SA.repository.appointment.impl;

import com.Booysen31SA.domain.appointment.DateAndTime;
import com.Booysen31SA.repository.appointment.IDateAndTimeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("DateAndTimeInMemory")
public class DateAndTimeRepositoryImpl implements IDateAndTimeRepository {

    private Set<DateAndTime> dateAndTimeDB;
    private static DateAndTimeRepositoryImpl DateAndTimeRepository = null;

    private DateAndTimeRepositoryImpl() {
        this.dateAndTimeDB = new HashSet<>();
    }

    public static DateAndTimeRepositoryImpl getDateAndTimeRepository() {
        if (DateAndTimeRepository == null) DateAndTimeRepository = new DateAndTimeRepositoryImpl();
        return DateAndTimeRepository;
    }
    @Override
    public DateAndTime create(DateAndTime dateAndTime) {
        if(read(dateAndTime.getPersal_Number()) == null){
            dateAndTimeDB.add(dateAndTime);
        }
        return dateAndTime;
    }

    @Override
    public DateAndTime read(String s) {
        return dateAndTimeDB.stream().filter(dateAndTime -> dateAndTime.getPersal_Number().equalsIgnoreCase(s)).findAny().orElse(null);

    }

    @Override
    public DateAndTime update(DateAndTime dateAndTime) {
        if(read(dateAndTime.getPersal_Number()) != null){
            delete(dateAndTime.getPersal_Number());
            create(dateAndTime);
        }
        return dateAndTime;
    }

    @Override
    public void delete(String s) {
        DateAndTime appointment = read(s);
        if(appointment != null){
            dateAndTimeDB.remove(appointment);
        }
    }

    @Override
    public Set<DateAndTime> getAll() {
        return dateAndTimeDB;
    }
}
