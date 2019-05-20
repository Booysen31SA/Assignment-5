package com.Booysen31SA.controller.retirement.finalizeRequest;

import com.Booysen31SA.domain.retirement.FinalizeRequest;
import com.Booysen31SA.factory.finalizeRequest.FinalizeRequestFactory;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class FinalizeRequestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/final";

    @Test
    public void create() {
        FinalizeRequest finalReq = FinalizeRequestFactory.Update(216062241,
                Misc.generateId(),
                45000.2,
                "Approved");


        ResponseEntity<FinalizeRequest> postResponse = restTemplate.postForEntity(baseURL + "/create" , finalReq, FinalizeRequest.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int persalNum = 216062241;
        FinalizeRequest obj = restTemplate.getForObject(baseURL + "/read/"+persalNum, FinalizeRequest.class);
//        obj.setPasalNumber(216062245);
        persalNum = 216066245;

        restTemplate.put(baseURL + "/update/"+persalNum, FinalizeRequest.class);
        FinalizeRequest updated = restTemplate.getForObject(baseURL+ "/update/"+persalNum, FinalizeRequest.class);
        assertNotNull(updated);
    }

    @Test
    public void delete() {
        int persalNum = 216062241;
        FinalizeRequest obj = restTemplate.getForObject(baseURL + "/delete/"+persalNum, FinalizeRequest.class);
        assertNull(obj);
        restTemplate.delete(baseURL+"/delete/"+persalNum, FinalizeRequest.class);
        try {
            obj = restTemplate.getForObject(baseURL+"/delete/"+persalNum, FinalizeRequest.class);
        }catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        FinalizeRequest obj = restTemplate.getForObject(baseURL+"/read/216062241", FinalizeRequest.class);
        System.out.println(obj.getPayout());
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