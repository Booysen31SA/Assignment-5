package com.Booysen31SA.services.retirement.impl;

import com.Booysen31SA.domain.retirement.Status;
import com.Booysen31SA.factory.retirement.StatusFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatusServiceImplTest {

    private Status status;
    private StatusServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = StatusServiceImpl.getService();
    }
    @Test
    public void getStatusService() {
        service = StatusServiceImpl.getService();
    }

    @Test
    public void create() {
        status = StatusFactory.buildStatus("216062241", "Declined");
        service.create(status);
        assertNotNull(service.read(status.getPersal_Number()));
    }

    @Test
    public void read() {
        status = StatusFactory.buildStatus("216062241", "Declined");
        service.create(status);
        assertNotNull(service.read(status.getPersal_Number()));
    }

    @Test
    public void update() {
        status = StatusFactory.buildStatus("216062241", "Declined");
        Status Updated = StatusFactory.buildStatus("216062241", "Approved");
        service.create(status);
        service.update(Updated);

        Status d = service.read(status.getPersal_Number());
        assertNotSame(status.getRequest(), d.getRequest());
    }

    @Test
    public void delete() {
        status = StatusFactory.buildStatus("216062241", "Declined");
        service.create(status);
        service.delete(status.getPersal_Number());
        assertNull(service.read(status.getPersal_Number()));
    }

    @Test
    public void getAll() {
        status = StatusFactory.buildStatus("216062241", "Declined");
        service.create(status);
        assertNotNull(service.getAll());
    }
}