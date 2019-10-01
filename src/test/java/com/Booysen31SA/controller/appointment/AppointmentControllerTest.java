package com.Booysen31SA.controller.appointment;

import com.Booysen31SA.EducationApplication;
import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.domain.appointment.DateAndTime;
import com.Booysen31SA.domain.appointment.Reason;
import com.Booysen31SA.factory.appointment.AppointmentFactory;
import com.Booysen31SA.factory.appointment.DateAndTimeFactory;
import com.Booysen31SA.factory.appointment.ReasonFactory;
import com.Booysen31SA.services.appointment.impl.AppointmentServiceImpl;
import com.Booysen31SA.services.appointment.impl.DateAndTimeServiceImpl;
import com.Booysen31SA.services.appointment.impl.ReasonServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.URI;
import java.util.Set;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentControllerTest {

    private static final String BASE_URL = "http://localhost:8080/appointment";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    AppointmentServiceImpl service;


    protected void setUp() {
        service = AppointmentServiceImpl.getService();
    }
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

@MockBean
private AppointmentCreation appointmentCreation;


    @Test
    public void create() throws Exception{
         Appointment appointment = AppointmentFactory.buildAppointment("216062241", "MAt");
         DateAndTime dateAndTime = DateAndTimeFactory.buildDateAndTime("216062241", "17h30", "17h30");
         Reason reason = ReasonFactory.buildReason("216062241", "visit");

         AppointmentCreation appointmentCreation = new AppointmentCreation(appointment, dateAndTime, reason);

        String inputJson = mapToJson(appointmentCreation);
        URI uri = new URI(BASE_URL+"/create");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<AppointmentCreation> request = new HttpEntity<>(appointmentCreation, headers);

        ResponseEntity<String> result = this.restTemplate.withBasicAuth("admin", "password").postForEntity(uri, request, String.class);

        System.out.println(result.getBody());
        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    public void read(){
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "password")
                .getForEntity(BASE_URL + "/read/216062241",  String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}