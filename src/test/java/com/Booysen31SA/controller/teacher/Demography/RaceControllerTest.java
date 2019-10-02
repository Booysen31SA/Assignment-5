package com.Booysen31SA.controller.teacher.Demography;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RaceControllerTest {

    private static final String BASE_URL = "http://localhost:8080/race";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createRace() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response
                = restTemplate
                .withBasicAuth("admin", "password")
                .postForEntity(BASE_URL+"/create/Coloured", entity, String.class);
        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getAll() {

        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "password")
                .getForEntity(BASE_URL + "/getall", String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void read(){
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "password")
                .getForEntity(BASE_URL + "/read/Male",  String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void updateRace() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response
                = restTemplate
                .withBasicAuth("admin", "password")
                .postForEntity(BASE_URL+"/update/Coloured", entity, String.class);
        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void delete(){
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "password")
                .getForEntity(BASE_URL + "/delete/216062241",  String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}