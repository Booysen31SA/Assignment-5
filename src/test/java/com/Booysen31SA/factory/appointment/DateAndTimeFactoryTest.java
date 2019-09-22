package com.Booysen31SA.factory.appointment;

import com.Booysen31SA.domain.appointment.DateAndTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateAndTimeFactoryTest {

    private DateAndTime dateAndTime;

    @Before
    public void setUp() throws Exception {
        dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17/02/2020", "17h30");
    }

    @Test
    public void buildDateAndTime() {
        assertNotNull(dateAndTime);
    }
}