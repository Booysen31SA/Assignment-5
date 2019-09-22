package com.Booysen31SA.services.teacher.users.address.impl;

import com.Booysen31SA.domain.teacher.user.address.Address;
import com.Booysen31SA.factory.teacher.user.address.AddressFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressServiceImplTest {

    private AddressServiceImpl service;
    private Address address;

    @Before
    public void setUp() throws Exception {
        service = AddressServiceImpl.getService();
    }

    @Test
    public void getService() {
    }

    @Test
    public void getAll() {
        address = AddressFactory.buildAddress("216062241", "fssgsg", "sdvvsd");
        service.create(address);
        assertNotNull(service.getAll());

    }

    @Test
    public void create() {
        address = AddressFactory.buildAddress("216062241", "fssgsg", "sdvvsd");
        service.create(address);
        assertNotNull(service.read(address.getPersal_Number()));
    }

    @Test
    public void read() {
        address = AddressFactory.buildAddress("216062241", "fssgsg", "sdvvsd");
        service.create(address);
        assertNotNull(service.read(address.getPersal_Number()));
    }

    @Test
    public void update() {
        address = AddressFactory.buildAddress("216062241", "fssgsg", "sdvvsd");
        Address Updated = AddressFactory.buildAddress("216062241", "fssgsg", "ddsv");
        service.update(Updated);
        service.create(address);
        assertNotNull(service.read(address.getPersal_Number()));
    }

    @Test
    public void delete() {
        address = AddressFactory.buildAddress("216062241", "fssgsg", "sdvvsd");
        service.create(address);
        service.delete(address.getPersal_Number());
        assertNull(service.read(address.getPersal_Number()));
    }
}