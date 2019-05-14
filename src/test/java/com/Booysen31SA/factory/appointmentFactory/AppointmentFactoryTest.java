package com.Booysen31SA.factory.appointmentFactory;

import com.Booysen31SA.domain.appointment.Appointment;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppointmentFactoryTest {

    @Test
    public void addAppointment() {

        Appointment app = AppointmentFactory.addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);

        assertNotNull(app);
        System.out.println(app);
    }
}