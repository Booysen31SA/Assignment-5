package com.Booysen31SA.controller.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.factory.appointmentFactory.AppointmentFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.net.http.HttpHeaders;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppointmentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/appointment";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        Appointment appointment = AppointmentFactory.addAppointment("17/02/2019", "17:30", "Clinton Booysen", "Retirement", 216062241);


        ResponseEntity<Appointment> postResponse = restTemplate.postForEntity(baseURL + "/create", appointment, Appointment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id =216062241;
        Appointment appoint = restTemplate.getForObject(baseURL + "/216062241/" + id, Appointment.class);

        restTemplate.put(baseURL + "/216062241/" + id, appoint);
        Appointment updatedAppointment = restTemplate.getForObject(baseURL + "/216062245/" + id, Appointment.class);
        assertNotNull(updatedAppointment);
    }

    @Test
    public void delete() {int id = 216062241;
        Appointment appointment = restTemplate.getForObject(baseURL + "/srtudent/" + id,Appointment.class);
        assertNotNull(appointment);
        restTemplate.delete(baseURL + "/students/" + id);
        try {
            appointment = restTemplate.getForObject(baseURL + "/employees/" + id, Appointment.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Appointment appointment = restTemplate.getForObject(baseURL + "/read/216062241", Appointment.class);
        System.out.println(appointment.toString());
        assertNotNull(appointment);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}