package com.Booysen31SA.controller.teacher.Demography;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GenderControllerTest {

    private static final String BASE_URL = "http://localhost:8080/gender";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createGender() {
        ResponseEntity result = restTemplate.withBasicAuth("admin", "password")
                .postForEntity(BASE_URL + "/create/female", null, String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getAll() {
        ResponseEntity<String> result = restTemplate.withBasicAuth("user", "password")
                .getForEntity(BASE_URL + "/getall", String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}