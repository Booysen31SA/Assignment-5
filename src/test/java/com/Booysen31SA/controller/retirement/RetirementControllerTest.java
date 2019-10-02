package com.Booysen31SA.controller.retirement;

import com.Booysen31SA.controller.appointment.AppointmentCreation;
import com.Booysen31SA.domain.retirement.Retirement;
import com.Booysen31SA.domain.retirement.Status;
import com.Booysen31SA.factory.retirement.RetirementFactory;
import com.Booysen31SA.factory.retirement.StatusFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URI;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RetirementControllerTest {

    private static final String BASE_URL = "http://localhost:8080/retirement";

    @Autowired
    private TestRestTemplate restTemplate;
    @Before
    public void setUp() throws Exception {
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
    private RetirementCreation retirementCreation;

    @Test
    public void create() throws Exception {
        Retirement retirement = RetirementFactory.buildRetirement("216062241", "1234567890", "Matjew", "Booysen", 45000);
        Status status = StatusFactory.buildStatus("216062241", "retirement");

        RetirementCreation retirementCreation = new RetirementCreation(retirement, status);
        URI uri = new URI(BASE_URL+"/create");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<RetirementCreation> request = new HttpEntity<>(retirementCreation, headers);

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

    @Test
    public void update() throws Exception{
        Retirement retirement = RetirementFactory.buildRetirement("216062241", "1234567890", "Matthew", "Booysen", 55000);
        Status status = StatusFactory.buildStatus("216062241", "retirement");

        RetirementCreation retirementCreation = new RetirementCreation(retirement, status);
        URI uri = new URI(BASE_URL+"/update");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<RetirementCreation> request = new HttpEntity<>(retirementCreation, headers);

        ResponseEntity<String> result = this.restTemplate.withBasicAuth("admin", "password").postForEntity(uri, request, String.class);

        System.out.println(result.getBody());
        assertEquals(200, result.getStatusCodeValue());
    }
    @Test
    public void delete(){
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "password")
                .getForEntity(BASE_URL + "/delete/216062241",  String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}