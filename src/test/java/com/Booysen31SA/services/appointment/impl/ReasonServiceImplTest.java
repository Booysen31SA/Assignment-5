package com.Booysen31SA.services.appointment.impl;

import com.Booysen31SA.domain.appointment.Reason;
import com.Booysen31SA.factory.appointment.ReasonFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReasonServiceImplTest {

    private Reason reason;
    private ReasonServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = ReasonServiceImpl.getService();
    }

    @Test
    public void getReasonService() {
        assertNotNull(service);
    }

    @Test
    public void create() {
        reason = ReasonFactory.buildReason("216062241", "jnsdvjsnvjvnsjvn");
        service.create(reason);
        assertNotNull(service.read(reason.getPersal_Number()));
    }

    @Test
    public void read() {
        reason = ReasonFactory.buildReason("216062241", "jnsdvjsnvjvnsjvn");
        service.create(reason);
        assertNotNull(service.read(reason.getPersal_Number()));
    }

    @Test
    public void update() {
        reason = ReasonFactory.buildReason("216062241", "jnsdvjsnvjvnsjvn");
        Reason updated = ReasonFactory.buildReason("216062241", "nknkcnskn");
        service.create(reason);
        service.update(updated);
        Reason d = service.read(reason.getPersal_Number());

        assertNotSame(reason.getReason(), d.getReason());
    }

    @Test
    public void delete() {
        reason = ReasonFactory.buildReason("216062241", "jnsdvjsnvjvnsjvn");
        service.create(reason);
        service.delete(reason.getPersal_Number());
        assertNull(service.read(reason.getPersal_Number()));
    }

    @Test
    public void getAll() {
        reason = ReasonFactory.buildReason("216062241", "jnsdvjsnvjvnsjvn");
        service.create(reason);
        assertNotNull(service.getAll());
    }
}
