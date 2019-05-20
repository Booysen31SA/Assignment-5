package com.Booysen31SA.controller.school;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.factory.transferFactory.TransferFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class SchoolControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/school";

    @Test
    public void create() {
        System.out.println("\nteacher amount increment");
        int currentAmountOfTeachersAtSchool = 21;
        String beforeTransfer = "South Peninsula";
        Transfer transfer = new TransferFactory().TransferSchool(216062241,
                beforeTransfer,
                "Plumstead High Transfer",
                currentAmountOfTeachersAtSchool,
                "Pending");
        ResponseEntity<Transfer> postResponse = restTemplate.postForEntity(baseURL+"/create", transfer, Transfer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int persalNum = 216062241;
        Transfer transfer = restTemplate.getForObject(baseURL + "/transfer/"+persalNum, Transfer.class);

        restTemplate.put(baseURL + "/transfer/"+persalNum, Transfer.class);
        Transfer updated = restTemplate.getForObject(baseURL+ "/transfer/"+persalNum, Transfer.class);
        assertNotNull(updated);
    }

    @Test
    public void delete() {
        int persalNum = 216062241;
        Transfer obj = restTemplate.getForObject(baseURL + "/transfer/"+persalNum, Transfer.class);
        assertNotNull(obj);
        restTemplate.delete(baseURL+"/transfer/"+persalNum, Transfer.class);
        try {
            obj = restTemplate.getForObject(baseURL+"/transfer/"+persalNum, Transfer.class);
        }catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Transfer obj = restTemplate.getForObject(baseURL+"/transfer/216062241", Transfer.class);
        System.out.println(obj.getPersalNumber());
        assertNotNull(obj);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response =  restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}