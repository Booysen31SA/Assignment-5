//package com.Booysen31SA.repository.teacher.users.userDemography.impl;
//
//import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
//import com.Booysen31SA.factory.teacher.user.userDemography.UserDemographyFactory;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class UserDemographyRepositoryImplTest {
//
//    private UserDemography userDemography;
//    private UserDemographyRepositoryImpl repository;
//
//    @Before
//    public void setUp() throws Exception {
//        repository = UserDemographyRepositoryImpl.getRepository();
//    }
//
//    @Test
//    public void getRepository() {
//    }
//
//    @Test
//    public void getAll() {
//        userDemography = UserDemographyFactory.buildUserDemography("216062241", "1", "2");
//        repository.create(userDemography);
//        assertNotNull(repository.getAll());
//    }
//
//    @Test
//    public void create() {
//        userDemography = UserDemographyFactory.buildUserDemography("216062241", "1", "2");
//        repository.create(userDemography);
//        assertNotNull(repository.read(userDemography.getPersal_Number()));
//    }
//
//    @Test
//    public void read() {
//        userDemography = UserDemographyFactory.buildUserDemography("216062241", "1", "2");
//        repository.create(userDemography);
//        assertNotNull(repository.read(userDemography.getPersal_Number()));
//    }
//
//    @Test
//    public void update() {
//        userDemography = UserDemographyFactory.buildUserDemography("216062241", "1", "2");
//
//        UserDemography Updated = UserDemographyFactory.buildUserDemography("216062241", "2", "2");
//        repository.create(userDemography);
//        repository.update(Updated);
//
//        UserDemography u =  repository.read(userDemography.getPersal_Number());
//        assertNotSame(userDemography.getGenderId(), u.getGenderId());
//    }
//
//    @Test
//    public void delete() {
//        userDemography = UserDemographyFactory.buildUserDemography("216062241", "1", "2");
//        repository.create(userDemography);
//        repository.delete(userDemography.getPersal_Number());
//        assertNull(repository.read(userDemography.getPersal_Number()));
//    }
//}