package com.Booysen31SA.services.teacher.demography.impl;

import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.factory.teacher.demography.RaceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class RaceServiceTest {

    private RaceService service;

    @Before
    public void setUp() throws Exception {
        this.service = RaceService.getService();
    }

    @Test
    public void getAll() {

        Set<Race> employeeSet = service.getAll();
        Assert.assertNotNull(employeeSet);

    }

    @Test
    public void create() {

        Race employee = RaceFactory.buildRace("fa");

        service.create(employee);

        Race inRepo = service.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        Race employee = RaceFactory.buildRace("fa");

        service.create(employee);

        Race inRepo = service.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        Race employee = RaceFactory.buildRace("fa");

        service.create(employee);
        Race inRepo = service.read(employee.getRaceId());

        employee.getRaceDescription();

        service.update(employee);

        Assert.assertEquals(employee.getRaceId(), inRepo.getRaceId());

    }

    @Test
    public void delete() {

        Race employee = RaceFactory.buildRace("fa");

        service.create(employee);

        Race inRepo = service.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);

        service.delete(employee.getRaceId());

        Race deleted = service.read(employee.getRaceId());

        Assert.assertNull(deleted);

    }

    @Test
    public void readByName() {

        Race employee = RaceFactory.buildRace("fa");

        service.create(employee);

        Race gender2 = service.getByName("fa");

        Assert.assertEquals(employee.getRaceDescription(), gender2.getRaceDescription());

    }
}