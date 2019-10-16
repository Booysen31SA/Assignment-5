package com.Booysen31SA.controller.school;

import com.Booysen31SA.controller.retirement.RetirementCreation;
import com.Booysen31SA.domain.school.Status;
import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.factory.school.StatusFactory;
import com.Booysen31SA.factory.school.TransferFactory;
import com.Booysen31SA.services.school.impl.TransferServiceImpl;
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
public class TransferControllerTest {

    private static final String BASE_URL = "http://localhost:8080/transfer";

    @Autowired
    private TestRestTemplate restTemplate;

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
    private TransferCreation transferCreation;

    @Test
    public void create() throws Exception{
        Transfer transfer = TransferFactory.buildTransfer("216062241", "SP", "mat", 80000);
        Status status = StatusFactory.buildStatus("216062241", "New");

        TransferCreation transferCreation = new TransferCreation(transfer, status);
        URI uri = new URI(BASE_URL+"/create");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<TransferCreation> request = new HttpEntity<>(transferCreation, headers);

        ResponseEntity<String> result = this.restTemplate
                .withBasicAuth("admin", "password")
                .postForEntity(uri, request, String.class);

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
        Transfer transfer = TransferFactory.buildTransfer("216062241", "SP", "mat", 80000);
        Status status = StatusFactory.buildStatus("216062241", "New");

        TransferCreation transferCreation = new TransferCreation(transfer, status);
        URI uri = new URI(BASE_URL+"/update");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<TransferCreation> request = new HttpEntity<>(transferCreation, headers);

        ResponseEntity<String> result = this.restTemplate
                .withBasicAuth("admin", "password")
                .postForEntity(uri, request, String.class);

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