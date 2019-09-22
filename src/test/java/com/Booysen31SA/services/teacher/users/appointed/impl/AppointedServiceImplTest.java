package com.Booysen31SA.services.teacher.users.appointed.impl;

import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
import com.Booysen31SA.factory.teacher.user.appointed.DateAppointedFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppointedServiceImplTest {

    private DateAppointed appointed;
    private AppointedServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = AppointedServiceImpl.getService();
    }
    @Test
    public void getDateAppointedService() {
        service = AppointedServiceImpl.getService();
    }

    @Test
    public void create() {
        appointed = DateAppointedFactory.buildDateAppointed("216062241", "sdvsdvvsvd");
        service.create(appointed);
        assertNotNull(service.read(appointed.getPersal_Number()));
    }

    @Test
    public void read() {
        appointed = DateAppointedFactory.buildDateAppointed("216062241", "sdvsdvvsvd");
        service.create(appointed);
        assertNotNull(service.read(appointed.getPersal_Number()));
    }

    @Test
    public void update() {
        appointed = DateAppointedFactory.buildDateAppointed("216062241", "sdvsdvvsvd");
        DateAppointed Updated = DateAppointedFactory.buildDateAppointed("216062241", "ngbfbdfbdf");
        service.create(appointed);
        service.update(Updated);

        DateAppointed d = service.read(appointed.getPersal_Number());
        assertNotSame(appointed.getDate(), d.getDate());
    }

    @Test
    public void delete() {
        appointed = DateAppointedFactory.buildDateAppointed("216062241", "sdvsdvvsvd");
        service.create(appointed);
        service.delete(appointed.getPersal_Number());
        assertNull(service.read(appointed.getPersal_Number()));
    }

    @Test
    public void getAll() {
        appointed = DateAppointedFactory.buildDateAppointed("216062241", "sdvsdvvsvd");
        service.create(appointed);
        assertNotNull(service.getAll());
    }
}