package com.Booysen31SA.services.impl.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.factory.appointmentFactory.AppointmentFactory;
import com.Booysen31SA.repository.impl.appointment.AppointmentRepositoryImpl;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentServiceImplTest {

    private AppointmentRepositoryImpl repository;
    private Appointment getClass;

    private Appointment getSaved(){return this.repository.getAll().iterator().next();}

    @Before
    public void setUp() throws Exception {
        this.repository = AppointmentRepositoryImpl.getAppointment();
        this.getClass = AppointmentFactory.addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);

    }

    @Test
    public void getAll() {
    }

    @Test
    public void create() {
        Appointment created = this.repository.create(this.getClass);
        System.out.println("Created : "+created);
        assertNotNull(created);
        assertSame(created, this.getClass);
    }

    @Test
    public void update() {
        Appointment app = this.repository.create(this.getClass);

        repository.create(app);

        Appointment updateapp = AppointmentFactory
                .addAppointment("17/02/2019", "15:30", "Clinton Booysen", "Retirement", 216062241);


        repository.update(updateapp);
        assertEquals(updateapp, repository.read(216062241));
        System.out.println(repository.getAll());
    }

    @Test
    public void delete() {
        Appointment app = this.repository.create(this.getClass);

        repository.create(app);

        //appointment.delete(216062241);
        //assertNull(appointment.read(216062241));
        System.out.println(repository.getAll());
    }

    @Test
    public void read() {
        Appointment app =this.repository.create(this.getClass);

        repository.create(app);
        assertNotNull(repository.read(216062241));
        System.out.println(repository.getAll());
    }
}