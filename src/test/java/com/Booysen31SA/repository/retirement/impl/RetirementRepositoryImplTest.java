package com.Booysen31SA.repository.retirement.impl;

import com.Booysen31SA.domain.retirement.Retirement;
import com.Booysen31SA.factory.retirement.RetirementFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RetirementRepositoryImplTest {

    private Retirement retirement;
    private RetirementRepositoryImpl repository;

    @Before
    public void setUp() throws Exception {
        repository = RetirementRepositoryImpl.getRetirementRepository();
    }
    @Test
    public void getRetirementRepository() {
        repository = RetirementRepositoryImpl.getRetirementRepository();
    }

    @Test
    public void create() {
        retirement = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 500000);
        repository.create(retirement);
        assertNotNull(repository.read(retirement.getPersal_Num()));
    }

    @Test
    public void read() {
        retirement = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 500000);
        repository.create(retirement);
        assertNotNull(repository.read(retirement.getPersal_Num()));
    }

    @Test
    public void update() {
        retirement = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 500000);
        Retirement Updated = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 600000);
        repository.create(retirement);
        repository.update(Updated);

        Retirement d = repository.read(retirement.getPersal_Num());
        assertNotSame(retirement.getPayout(), d.getPayout());
    }

    @Test
    public void delete() {
        retirement = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 500000);
        repository.create(retirement);
        repository.delete(retirement.getPersal_Num());
        assertNull(repository.read(retirement.getPersal_Num()));
    }

    @Test
    public void getAll() {
        retirement = RetirementFactory.buildRetirement("216062241", 215823684652L, "ascascasc", "scsdssdv", 500000);
        repository.create(retirement);
        assertNotNull(repository.getAll());
    }
}