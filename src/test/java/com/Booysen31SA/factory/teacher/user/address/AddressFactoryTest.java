package com.Booysen31SA.factory.teacher.user.address;

import com.Booysen31SA.domain.teacher.user.address.Address;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressFactoryTest {

    private Address address;

    @Before
    public void setUp() throws Exception {
        address = AddressFactory.buildAddress("216062241", "scsdcsd", "scsdcs");
    }

    @Test
    public void buildAddress() {
        assertNotNull(address);
    }
}