6vpackage com.Booysen31SA.controller.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.factory.appointmentFactory.AppointmentFactory;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.HttpClientErrorException;


import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class AppointmentControllerTest{

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/appointment";

    @Test
    //@org.testng.annotations.Test(priority = 1)
    public void create() {
        Appointment appointment = AppointmentFactory.addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);
        System.out.println(appointment);

        ResponseEntity<Appointment> postResponse = restTemplate.postForEntity(baseURL + "/create", appointment, Appointment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Create");
    }


    //@org.testng.annotations.Test(dependsOnMethods = "create")
    @Test
    public void read() {
        Appointment appointment = restTemplate.getForObject(baseURL + "/read/216062241", Appointment.class);
        System.out.println("Read");
        assertNotNull(appointment);
    }

    //@org.testng.annotations.Test(dependsOnMethods = "read")
    @Test
    public void update() {
        int id =216062241;
        Appointment appoint = restTemplate.getForObject(baseURL + "/216062241/" + id, Appointment.class);

        restTemplate.put(baseURL + "/216062241/" + id, appoint);
        Appointment updatedAppointment = restTemplate.getForObject(baseURL + "/216062245/" + id, Appointment.class);
        assertNotNull(updatedAppointment);
    }

    //@org.testng.annotations.Test(dependsOnMethods = "update")
    @Test
    public void delete() {int id = 216062245;
        Appointment appointment = restTemplate.getForObject(baseURL + "/delete/" + id,Appointment.class);
        assertNull(appointment);
        restTemplate.delete(baseURL + "/students/" + id);
        try {
            appointment = restTemplate.getForObject(baseURL + "/employees/" + id, Appointment.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    //@org.testng.annotations.Test(priority = 2)
    public void read() {
        Appointment appointment = restTemplate.getForObject(baseURL + "/read/216062241", Appointment.class);
        assertNotNull(appointment);
    }

    @Test()
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}