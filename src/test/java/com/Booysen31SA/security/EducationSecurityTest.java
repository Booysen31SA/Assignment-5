package com.Booysen31SA.security;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

public class EducationSecurityTest {
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/appointment";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void configure() {
    }

    @Test
    public void testConfigure() {
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "password")
                .getForEntity(baseURL + "/test/1", String.class);
        System.out.println(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

}