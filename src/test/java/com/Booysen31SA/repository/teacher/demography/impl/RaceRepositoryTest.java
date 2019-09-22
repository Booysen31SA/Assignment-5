package com.Booysen31SA.repository.teacher.demography.impl;

import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.factory.teacher.demography.RaceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class RaceRepositoryTest {

    private RaceRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = RaceRepository.raceRepository();
    }


    @Test
    public void getAll() {

        Race employee = RaceFactory.buildRace("fa");
        repository.create(employee);
        Assert.assertNotNull(repository.getAll());

    }

    @Test
    public void create() {

        Race employee = RaceFactory.buildRace("fa");

        repository.create(employee);

        Race inRepo = repository.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        Race employee = RaceFactory.buildRace("fa");

        repository.create(employee);

        Race inRepo = repository.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        Race employee = RaceFactory.buildRace("Indian");
        repository.create(employee);

        Race updatedRace =  RaceFactory.buildRace("White");

        repository.update(updatedRace);

        Assert.assertNotEquals(employee.getRaceDescription(), updatedRace.getRaceDescription());

    }

    @Test
    public void delete() {

        Race employee = RaceFactory.buildRace("fa");

        repository.create(employee);

        Race inRepo = repository.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);

        repository.delete(employee.getRaceId());

        Race deleted = repository.read(employee.getRaceId());

        Assert.assertNull(deleted);

    }
}