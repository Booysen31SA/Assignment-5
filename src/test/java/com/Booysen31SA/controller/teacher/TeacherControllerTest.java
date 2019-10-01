package com.Booysen31SA.controller.teacher;

import com.Booysen31SA.controller.school.TransferCreation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.Assert.*;

public class TeacherControllerTest {

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
    private TeacherCreation teacherCreation;

    @Test
    public void test1() {
    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void read(){
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "password")
                .getForEntity(BASE_URL + "/read/216062241",  String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getAll() {
    }
}