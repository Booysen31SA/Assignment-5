package com.Booysen31SA.services.teacher.demography.impl;

import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.factory.teacher.demography.GenderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class GenderServiceTest {

    private GenderService service;

    @Before
    public void setUp() throws Exception {
        this.service = GenderService.getService();
    }

    @Test
    public void getAll() {
        Assert.assertNotNull(service.getAll());

    }

    @Test
    public void create() {

        Gender employee = GenderFactory.buildGender("M");

        service.create(employee);

        Gender inRepo = service.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        Gender employee = GenderFactory.buildGender("M");

        service.create(employee);

        Gender inRepo = service.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        Gender employee = GenderFactory.buildGender("M");

        service.create(employee);
        Gender inRepo = service.read(employee.getGenderId());

        employee.getGenderDescription();

        service.update(employee);

        Assert.assertEquals(employee.getGenderId(), inRepo.getGenderId());

    }

    @Test
    public void delete() {

        Gender employee = GenderFactory.buildGender("M");

        service.create(employee);

        Gender inRepo = service.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);

        service.delete(employee.getGenderId());

        Gender deleted = service.read(employee.getGenderId());

        Assert.assertNull(deleted);

    }

    @Test
    public void readByName() {

        Gender employee = GenderFactory.buildGender("M");

        service.create(employee);

        Gender gender2 = service.getByName("M");

        Assert.assertEquals(employee.getGenderDescription(), gender2.getGenderDescription());


    }
}