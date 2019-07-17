package com.Booysen31SA.controller.retirement.putRequest;

import com.Booysen31SA.domain.retirement.PutRequest;
import com.Booysen31SA.factory.putRequestFactory.PutRequestFactory;
import com.Booysen31SA.util.Misc;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PutRequestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/final";

    @Test
    public void create() {
        PutRequest finalReq =PutRequestFactory.requestAdd(216062241,
                "5",
                "Matthew",
                "Booysen",
                45000.2);


        ResponseEntity<PutRequest> postResponse = restTemplate.postForEntity(baseURL + "/create" , finalReq, PutRequest.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int persalNum = 216062241;
        PutRequest obj = restTemplate.getForObject(baseURL + "/read/"+persalNum, PutRequest.class);
//        obj.setPasalNumber(216062245);
        persalNum = 216066245;

        restTemplate.put(baseURL + "/update/"+persalNum, PutRequest.class);
        PutRequest updated = restTemplate.getForObject(baseURL+ "/update/"+persalNum, PutRequest.class);
        assertNotNull(updated);
    }

    @Test
    public void delete() {
        int persalNum = 216062241;
        PutRequest obj = restTemplate.getForObject(baseURL + "/delete/"+persalNum, PutRequest.class);
        assertNull(obj);
        restTemplate.delete(baseURL+"/delete/"+persalNum, PutRequest.class);
        try {
            obj = restTemplate.getForObject(baseURL+"/delete/"+persalNum, PutRequest.class);
        }catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        PutRequest obj = restTemplate.getForObject(baseURL+"/read/216062241", PutRequest.class);
//        System.out.println(obj.getPayout());
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