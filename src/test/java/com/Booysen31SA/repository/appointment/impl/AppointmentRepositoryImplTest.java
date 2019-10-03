//package com.Booysen31SA.repository.appointment.impl;
//
//import com.Booysen31SA.domain.appointment.Appointment;
//import com.Booysen31SA.factory.appointment.AppointmentFactory;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class AppointmentRepositoryImplTest {
//
//    private Appointment appointment;
//    private AppointmentRepositoryImpl repository;
//
//    @Before
//    public void setUp() throws Exception {
//        repository = AppointmentRepositoryImpl.getAppointmentRepository();
//    }
//    @Test
//    public void getAppointmentRepository() {
//        repository = AppointmentRepositoryImpl.getAppointmentRepository();
//    }
//
//    @Test
//    public void create() {
//        appointment = AppointmentFactory.buildAppointment("216062241", "Marvin");
//        repository.create(appointment);
//        assertNotNull(repository.read(appointment.getPersalNumber()));
//    }
//
//    @Test
//    public void read() {
//        appointment = AppointmentFactory.buildAppointment("216062241", "Marvin");
//        repository.create(appointment);
//        assertNotNull(repository.read(appointment.getPersalNumber()));
//    }
//
//    @Test
//    public void update() {
//        appointment = AppointmentFactory.buildAppointment("216062241", "Marvin");
// Appointment Updated = AppointmentFactory.buildAppointment("216062241", "Matthew");
//        repository.create(appointment);
//        repository.update(Updated);
//        assertNotNull(repository.read(appointment.getPersalNumber()));
//    }
//
//    @Test
//    public void delete() {
//        appointment = AppointmentFactory.buildAppointment("216062241", "Marvin");
//        repository.create(appointment);
//        repository.delete(appointment.getPersalNumber());
//        assertNull(repository.read(appointment.getPersalNumber()));
//    }
//
//    @Test
//    public void getAll() {
//        appointment = AppointmentFactory.buildAppointment("216062241", "Marvin");
//        repository.create(appointment);
//        assertNotNull(repository.getAll());
//    }
//}