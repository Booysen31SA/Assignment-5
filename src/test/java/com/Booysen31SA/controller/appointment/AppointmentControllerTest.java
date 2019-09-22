6vpackage com.Booysen31SA.controller.appointment;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
<<<<<<< HEAD
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
=======

import static org.junit.Assert.*;

public class AppointmentControllerTest {
>>>>>>> Develop

    @Before
    public void setUp() throws Exception {
    }

<<<<<<< HEAD
=======
    @Test
    public void test1() {
    }

>>>>>>> Develop
    @Test
    public void create() {
<<<<<<< HEAD
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
=======
>>>>>>> Develop
    }

    //@org.testng.annotations.Test(dependsOnMethods = "read")
    @Test
    public void update() {
    }

    //@org.testng.annotations.Test(dependsOnMethods = "update")
    @Test
<<<<<<< HEAD
    public void delete() {int id = 216062245;
        Appointment appointment = restTemplate.getForObject(baseURL + "/delete/" + id,Appointment.class);
        assertNull(appointment);
        restTemplate.delete(baseURL + "/students/" + id);
        try {
            appointment = restTemplate.getForObject(baseURL + "/employees/" + id, Appointment.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
=======
    public void delete() {
>>>>>>> Develop
    }

    @Test
    public void read() {
    }

    @Test
    public void getAll() {
    }
}