package factory.appointmentFactory;

import domain.appointment.Apointment;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppointmentFactoryTest {

    @Test
    public void addAppointment() {

        Apointment app = AppointmentFactory.addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);

        assertNotNull(app);
        System.out.println(app);
    }
}