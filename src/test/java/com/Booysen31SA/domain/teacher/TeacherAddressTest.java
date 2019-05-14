package com.Booysen31SA.domain.teacher;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherAddressTest {

    private TeacherAddress teachadd;

    @Before
    public void setUp() {
        teachadd = new TeacherAddress("32 South Road", "32 South Road");


    }

    @Test
    public void addressTest(){

        assertEquals("32 South Road", teachadd.getPhysicalAddress());
    }
}