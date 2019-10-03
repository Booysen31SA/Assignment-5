//package com.Booysen31SA.repository.teacher.users.appointed.impl;
//
//import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
//import com.Booysen31SA.factory.teacher.user.appointed.DateAppointedFactory;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class AppointedRepositoryImplTest {
//
//    private DateAppointed appointed;
//    private AppointedRepositoryImpl repository;
//
//    @Before
//    public void setUp() throws Exception {
//        repository = AppointedRepositoryImpl.getRepository();
//    }
//    @Test
//    public void getDateAppointedRepository() {
//        repository = AppointedRepositoryImpl.getRepository();
//    }
//
//    @Test
//    public void create() {
//        appointed = DateAppointedFactory.buildDateAppointed("216062241", "sdvsdvvsvd");
//        repository.create(appointed);
//        assertNotNull(repository.read(appointed.getPersal_Number()));
//    }
//
//    @Test
//    public void read() {
//        appointed = DateAppointedFactory.buildDateAppointed("216062241", "sdvsdvvsvd");
//        repository.create(appointed);
//        assertNotNull(repository.read(appointed.getPersal_Number()));
//    }
//
//    @Test
//    public void update() {
//        appointed = DateAppointedFactory.buildDateAppointed("216062241", "sdvsdvvsvd");
//        DateAppointed Updated = DateAppointedFactory.buildDateAppointed("216062241", "ngbfbdfbdf");
//        repository.create(appointed);
//        repository.update(Updated);
//
//        DateAppointed d = repository.read(appointed.getPersal_Number());
//        assertNotSame(appointed.getDate(), d.getDate());
//    }
//
//    @Test
//    public void delete() {
//        appointed = DateAppointedFactory.buildDateAppointed("216062241", "sdvsdvvsvd");
//        repository.create(appointed);
//        repository.delete(appointed.getPersal_Number());
//        assertNull(repository.read(appointed.getPersal_Number()));
//    }
//
//    @Test
//    public void getAll() {
//        appointed = DateAppointedFactory.buildDateAppointed("216062241", "sdvsdvvsvd");
//        repository.create(appointed);
//        assertNotNull(repository.getAll());
//    }
//}