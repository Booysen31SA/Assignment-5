package com.Booysen31SA.services.appointment.impl;

import com.Booysen31SA.domain.appointment.DateAndTime;
import com.Booysen31SA.factory.appointment.DateAndTimeFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateAndTimeServiceImplTest {

    private DateAndTime dateAndTime;
    private DateAndTimeServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = DateAndTimeServiceImpl.getService();
    }

    @Test
    public void getDateAndTimeService() {
        assertNotNull(service);
    }

    @Test
    public void create() {
        dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "17h30");
        service.create(dateAndTime);
        assertNotNull(service.read(dateAndTime.getPersal_Number()));
    }

    @Test
    public void read() {
        dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "17h30");
        service.create(dateAndTime);
        assertNotNull(service.read(dateAndTime.getPersal_Number()));
    }

    @Test
    public void update() {
        dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "17h30");
        DateAndTime updated = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "18h30");
        service.create(dateAndTime);
        service.update(updated);
        DateAndTime d = service.read(dateAndTime.getPersal_Number());

        assertNotSame(dateAndTime.getTime(), d.getTime());
    }

    @Test
    public void delete() {
        dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "17h30");
        service.create(dateAndTime);
        service.delete(dateAndTime.getPersal_Number());
        assertNull(service.read(dateAndTime.getPersal_Number()));
    }

    @Test
    public void getAll() {
        dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/1997", "17h30");
        service.create(dateAndTime);
        assertNotNull(service.getAll());
    }
}
