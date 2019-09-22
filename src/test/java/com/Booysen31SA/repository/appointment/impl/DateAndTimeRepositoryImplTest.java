package com.Booysen31SA.repository.appointment.impl;

import com.Booysen31SA.domain.appointment.DateAndTime;
import com.Booysen31SA.factory.appointment.DateAndTimeFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateAndTimeRepositoryImplTest {

    private DateAndTime dateAndTime;
    private DateAndTimeRepositoryImpl repository;

    @Before
    public void setUp() throws Exception {
        repository = DateAndTimeRepositoryImpl.getDateAndTimeRepository();
    }

    @Test
    public void getDateAndTimeRepository() {
        assertNotNull(repository);
    }

    @Test
    public void create() {
        dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "17h30");
        repository.create(dateAndTime);
        assertNotNull(repository.read(dateAndTime.getPersal_Number()));
    }

    @Test
    public void read() {
        dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "17h30");
        repository.create(dateAndTime);
        assertNotNull(repository.read(dateAndTime.getPersal_Number()));
    }

    @Test
    public void update() {
        dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "17h30");
        DateAndTime updated = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "18h30");
        repository.create(dateAndTime);
        repository.update(updated);
        DateAndTime d = repository.read(dateAndTime.getPersal_Number());

        assertNotSame(dateAndTime.getTime(), d.getTime());
    }

    @Test
    public void delete() {
        dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "17h30");
        repository.create(dateAndTime);
        repository.delete(dateAndTime.getPersal_Number());
        assertNull(repository.read(dateAndTime.getPersal_Number()));
    }

    @Test
    public void getAll() {
        dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "17h30");
        repository.create(dateAndTime);
        assertNotNull(repository.getAll());
    }
}