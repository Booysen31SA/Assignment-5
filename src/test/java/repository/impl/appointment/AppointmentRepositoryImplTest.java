package repository.impl.appointment;

import domain.appointment.Apointment;
import domain.appointment.DateAndTime;
import factory.appointmentFactory.AppointmentFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppointmentRepositoryImplTest {

    AppointmentRepositoryImpl appointment;

    @Before
    public void setUp() throws Exception {
        appointment = AppointmentRepositoryImpl.getAppointment();
    }


    @Test
    public void getAll() {
    }

    @Test
    public void create() {
        Apointment app = AppointmentFactory
                .addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);

        appointment.create(app);
        assertNotNull(appointment.getAll());
        System.out.println(appointment.getAll());

    }

    @Test
    public void update() {
        Apointment app = AppointmentFactory
                .addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);

        appointment.create(app);

        Apointment updateapp = AppointmentFactory
                .addAppointment("17/02/2019", "15:30", "Clinton Booysen", "Retirement", 216062241);


        appointment.update(updateapp);
        assertEquals(updateapp, appointment.read(216062241));
        System.out.println(appointment.getAll());
    }

    @Test
    public void delete() {
        Apointment app = AppointmentFactory
                .addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);

        appointment.create(app);

        //appointment.delete(216062241);
        //assertNull(appointment.read(216062241));
        System.out.println(appointment.getAll());
    }

    @Test
    public void read() {
        Apointment app = AppointmentFactory
                .addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);

        appointment.create(app);
        assertNotNull(appointment.read(216062241));
        System.out.println(appointment.getAll());
    }

}