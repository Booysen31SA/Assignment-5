//package com.Booysen31SA.repository.appointment.impl;
//
//import com.Booysen31SA.domain.appointment.Reason;
//import com.Booysen31SA.factory.appointment.ReasonFactory;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class ReasonRepositoryImplTest {
//
//    private Reason reason;
//    private ReasonRepositoryImpl repository;
//
//    @Before
//    public void setUp() throws Exception {
//        repository = ReasonRepositoryImpl.getReasonRepository();
//    }
//
//    @Test
//    public void getReasonRepository() {
//        assertNotNull(repository);
//    }
//
//    @Test
//    public void create() {
//        reason = ReasonFactory.buildReason("216062241", "jnsdvjsnvjvnsjvn");
//        repository.create(reason);
//        assertNotNull(repository.read(reason.getPersal_Number()));
//    }
//
//    @Test
//    public void read() {
//        reason = ReasonFactory.buildReason("216062241", "jnsdvjsnvjvnsjvn");
//        repository.create(reason);
//        assertNotNull(repository.read(reason.getPersal_Number()));
//    }
//
//    @Test
//    public void update() {
//        reason = ReasonFactory.buildReason("216062241", "jnsdvjsnvjvnsjvn");
//        Reason updated = ReasonFactory.buildReason("216062241", "nknkcnskn");
//        repository.create(reason);
//        repository.update(updated);
//        Reason d = repository.read(reason.getPersal_Number());
//
//        assertNotSame(reason.getReason(), d.getReason());
//    }
//
//    @Test
//    public void delete() {
//        reason = ReasonFactory.buildReason("216062241", "jnsdvjsnvjvnsjvn");
//        repository.create(reason);
//        repository.delete(reason.getPersal_Number());
//        assertNull(repository.read(reason.getPersal_Number()));
//    }
//
//    @Test
//    public void getAll() {
//        reason = ReasonFactory.buildReason("216062241", "jnsdvjsnvjvnsjvn");
//        repository.create(reason);
//        assertNotNull(repository.getAll());
//    }
//}
