package com.Booysen31SA.repository.impl.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.factory.appointmentFactory.AppointmentFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppointmentRepositoryImplTest {

    AppointmentRepositoryImpl appointment;

    @Before
    public void setUp() {
        appointment = AppointmentRepositoryImpl.getAppointment();
    }


    @Test
    public void getAll() {
    }

    @Test
    public void create() {
        Appointment app = AppointmentFactory
                .addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);

        appointment.create(app);
        assertNotNull(appointment.getAll());
        System.out.println(appointment.getAll());

    }

    @Test
    public void update() {
        Appointment app = AppointmentFactory
                .addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);

        appointment.create(app);

        Appointment updateapp = AppointmentFactory
                .addAppointment("17/02/2019", "15:30", "Clinton Booysen", "Retirement", 216062241);


        appointment.update(updateapp);
        assertEquals(updateapp, appointment.read(216062241));
        System.out.println(appointment.getAll());
    }

    @Test
    public void delete() {
        Appointment app = AppointmentFactory
                .addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);

        appointment.create(app);

        //appointment.delete(216062241);
        //assertNull(appointment.read(216062241));
        System.out.println(appointment.getAll());
    }

    @Test
    public void read() {
        Appointment app = AppointmentFactory
                .addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);

        appointment.create(app);
        assertNotNull(appointment.read(216062241));
        System.out.println(appointment.getAll());
    }

}