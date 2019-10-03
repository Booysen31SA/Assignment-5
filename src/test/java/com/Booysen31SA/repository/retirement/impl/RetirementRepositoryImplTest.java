//package com.Booysen31SA.repository.retirement.impl;
//
//import com.Booysen31SA.domain.retirement.Retirement;
//import com.Booysen31SA.factory.retirement.RetirementFactory;
//import com.Booysen31SA.repository.retirement.IRetirementRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RetirementRepositoryImplTest {
//
//    private Retirement retirement;
//    private IRetirementRepository repository;
//
//    @Before
//    public void setUp() throws Exception {
//    }
//    @Test
//    public void getRetirementRepository() {
//
//    }
//
//    @Test
//    public void create() {
//        retirement = RetirementFactory.buildRetirement("216062241", "215823684652", "ascascasc", "scsdssdv", 500000);
//        repository.create(retirement);
//        assertNotNull(repository.read(retirement.getPersal_Num()));
//    }
//
//    @Test
//    public void read() {
//        retirement = RetirementFactory.buildRetirement("216062241", "215823684652", "ascascasc", "scsdssdv", 500000);
//        repository.create(retirement);
//        assertNotNull(repository.read(retirement.getPersal_Num()));
//    }
//
//    @Test
//    public void update() {
//        retirement = RetirementFactory.buildRetirement("216062241", "215823684652", "ascascasc", "scsdssdv", 500000);
//        Retirement Updated = RetirementFactory.buildRetirement("216062241", "215823684652", "ascascasc", "scsdssdv", 600000);
//        repository.create(retirement);
//        repository.update(Updated);
//
//        Retirement d = repository.read(retirement.getPersal_Num());
//        assertNotSame(retirement.getPayout(), d.getPayout());
//    }
//
//    @Test
//    public void delete() {
//        retirement = RetirementFactory.buildRetirement("216062241", "215823684652", "ascascasc", "scsdssdv", 500000);
//        repository.create(retirement);
//        repository.delete(retirement.getPersal_Num());
//        assertNull(repository.read(retirement.getPersal_Num()));
//    }
//
//    @Test
//    public void getAll() {
//        retirement = RetirementFactory.buildRetirement("216062241", "215823684652", "ascascasc", "scsdssdv", 500000);
//        repository.create(retirement);
//        assertNotNull(repository.getAll());
//    }
//}