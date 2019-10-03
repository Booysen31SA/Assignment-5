//package com.Booysen31SA.repository.teacher.users.address.impl;
//
//import com.Booysen31SA.domain.teacher.user.address.Address;
//import com.Booysen31SA.factory.teacher.user.address.AddressFactory;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class AddressRepositoryImplTest {
//
//    private Address address;
//    private AddressRepositoryImpl repository;
//
//    @Before
//    public void setUp() throws Exception {
//        repository = AddressRepositoryImpl.getRepository();
//    }
//    @Test
//    public void getAddressRepository() {
//        repository = AddressRepositoryImpl.getRepository();
//    }
//
//    @Test
//    public void create() {
//        address = AddressFactory.buildAddress("216062241", "sdvsdvvsvd", "dvvvvsdvsd");
//        repository.create(address);
//        assertNotNull(repository.read(address.getPersal_Number()));
//    }
//
//    @Test
//    public void read() {
//        address = AddressFactory.buildAddress("216062241", "sdvsdvvsvd", "dvvvvsdvsd");
//        repository.create(address);
//        assertNotNull(repository.read(address.getPersal_Number()));
//    }
//
//    @Test
//    public void update() {
//        address = AddressFactory.buildAddress("216062241", "sdvsdvvsvd", "dvvvvsdvsd");
//        Address Updated = AddressFactory.buildAddress("216062241", "sdvsdvvsvd", "vdvssd");
//        repository.create(address);
//        repository.update(Updated);
//
//        Address d = repository.read(address.getPersal_Number());
//        assertNotSame(address.getPostalAddress(), d.getPostalAddress());
//    }
//
//    @Test
//    public void delete() {
//        address = AddressFactory.buildAddress("216062241", "sdvsdvvsvd", "dvvvvsdvsd");
//        repository.create(address);
//        repository.delete(address.getPersal_Number());
//        assertNull(repository.read(address.getPersal_Number()));
//    }
//
//    @Test
//    public void getAll() {
//        address = AddressFactory.buildAddress("216062241", "sdvsdvvsvd", "dvvvvsdvsd");
//        repository.create(address);
//        assertNotNull(repository.getAll());
//    }
//}