package com.Booysen31SA.services.retirement.impl;

import com.Booysen31SA.domain.retirement.Retirement;
import com.Booysen31SA.factory.retirement.RetirementFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RetirementServiceImplTest {

    private Retirement retirement;
    private RetirementServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = RetirementServiceImpl.getService();
    }
    @Test
    public void getRetirementService() {
        service = RetirementServiceImpl.getService();
    }

    @Test
    public void create() {
        retirement = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 500000);
        service.create(retirement);
        assertNotNull(service.read(retirement.getPersal_Num()));
    }

    @Test
    public void read() {
        retirement = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 500000);
        service.create(retirement);
        assertNotNull(service.read(retirement.getPersal_Num()));
    }

    @Test
    public void update() {
        retirement = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 500000);
        Retirement Updated = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 600000);
        service.create(retirement);
        service.update(Updated);

        Retirement d = service.read(retirement.getPersal_Num());
        assertNotSame(retirement.getPayout(), d.getPayout());
    }

    @Test
    public void delete() {
        retirement = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 500000);
        service.create(retirement);
        service.delete(retirement.getPersal_Num());
        assertNull(service.read(retirement.getPersal_Num()));
    }

    @Test
    public void getAll() {
        retirement = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 500000);
        service.create(retirement);
        assertNotNull(service.getAll());
    }
}