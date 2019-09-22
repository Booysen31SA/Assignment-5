package com.Booysen31SA.repository.teacher.demography.impl;

import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.factory.teacher.demography.GenderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class GenderRepositoryTest {

    private GenderRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = GenderRepository.getRepository();
    }


    @Test
    public void getAll() {

        Set<Gender> employeeSet = repository.getAll();
        Assert.assertNotNull(employeeSet);

    }

    @Test
    public void create() {

        Gender employee = GenderFactory.buildGender("M");

        repository.create(employee);

        Gender inRepo = repository.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        Gender employee = GenderFactory.buildGender("M");

        repository.create(employee);

        Gender inRepo = repository.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        Gender employee = GenderFactory.buildGender("M");
        repository.create(employee);

        Gender updatedEmployee = GenderFactory.buildGender("F");

        repository.update(updatedEmployee);

        Assert.assertNotEquals(employee.getGenderDescription(), updatedEmployee.getGenderDescription());

    }

    @Test
    public void delete() {

        Gender employee = GenderFactory.buildGender("M");

        repository.create(employee);

        Gender inRepo = repository.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);

        repository.delete(employee.getGenderId());

        Gender deleted = repository.read(employee.getGenderId());

        Assert.assertNull(deleted);

    }
}