package com.Booysen31SA.services.appointment.impl;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.factory.appointment.AppointmentFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppointmentServiceImplTest {

    private Appointment appointment;
    private AppointmentServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = AppointmentServiceImpl.getService();
    }
    @Test
    public void getAppointmentService() {
        service = AppointmentServiceImpl.getService();
    }

    @Test
    public void create() {
        appointment = AppointmentFactory.buildAppointment("216062241", "Marvin");
        service.create(appointment);
        assertNotNull(service.read(appointment.getPersalNumber()));
    }

    @Test
    public void read() {
        appointment = AppointmentFactory.buildAppointment("216062241", "Marvin");
        service.create(appointment);
        assertNotNull(service.read(appointment.getPersalNumber()));
    }

    @Test
    public void update() {
        appointment = AppointmentFactory.buildAppointment("216062241", "Marvin");
        Appointment Updated = AppointmentFactory.buildAppointment("216062241", "Matthew");
        service.create(appointment);
        service.update(Updated);
        assertNotNull(service.read(appointment.getPersalNumber()));
    }

    @Test
    public void delete() {
        appointment = AppointmentFactory.buildAppointment("216062241", "Marvin");
        service.create(appointment);
        service.delete(appointment.getPersalNumber());
        assertNull(service.read(appointment.getPersalNumber()));
    }

    @Test
    public void getAll() {
        appointment = AppointmentFactory.buildAppointment("216062241", "Marvin");
        service.create(appointment);
        assertNotNull(service.getAll());
    }
}