package com.Booysen31SA.factory.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppointmentFactoryTest {

    private Appointment appointment;

    @Before
    public void setUp() throws Exception {
        appointment = AppointmentFactory.buildAppointment("216062241", "Marvin");
    }

    @Test
    public void buildAppointment() {
        assertNotNull(appointment);
    }
}