package com.Booysen31SA.services.teacher.users.userDemography.impl;

import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
import com.Booysen31SA.factory.teacher.user.userDemography.UserDemographyFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDemographyServiceImplTest {

    private UserDemography userDemography;
    private UserDemographyServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = UserDemographyServiceImpl.getService();
    }

    @Test
    public void getService() {
    }

    @Test
    public void getAll() {
        userDemography = UserDemographyFactory.buildUserDemography("216062241", "1", "2");
        service.create(userDemography);
        assertNotNull(service.getAll());
    }

    @Test
    public void create() {
        userDemography = UserDemographyFactory.buildUserDemography("216062241", "1", "2");
        service.create(userDemography);
        assertNotNull(service.read(userDemography.getPersal_Number()));
    }

    @Test
    public void read() {
        userDemography = UserDemographyFactory.buildUserDemography("216062241", "1", "2");
        service.create(userDemography);
        assertNotNull(service.read(userDemography.getPersal_Number()));
    }

    @Test
    public void update() {
        userDemography = UserDemographyFactory.buildUserDemography("216062241", "1", "2");

        UserDemography Updated = UserDemographyFactory.buildUserDemography("216062241", "2", "2");
        service.create(userDemography);
        service.update(Updated);

        UserDemography u =  service.read(userDemography.getPersal_Number());
        assertNotSame(userDemography.getGenderId(), u.getGenderId());
    }

    @Test
    public void delete() {
        userDemography = UserDemographyFactory.buildUserDemography("216062241", "1", "2");
        service.create(userDemography);
        service.delete(userDemography.getPersal_Number());
        assertNull(service.read(userDemography.getPersal_Number()));
    }
}