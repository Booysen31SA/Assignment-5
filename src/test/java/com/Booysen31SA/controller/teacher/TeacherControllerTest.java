package com.Booysen31SA.controller.teacher;

import com.Booysen31SA.domain.teacher.Teacher;
import com.Booysen31SA.factory.teacherFactory.TeacherFactory;
import com.Booysen31SA.util.Misc;
import com.Booysen31SA.util.genericvalueobjects.ContactDetails;
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


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeacherControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/teacher";


    @Test
    public void create() {
        ContactDetails con = new ContactDetails.Builder().setCellNumber("0741873430").setHomeNumber("").build();
        Teacher teach = TeacherFactory.AddTeacher(216062241,
                "Matthew",
                "Booysen",
                "17/02/1997",
                "1702",
                "32 South Road",
                "32 South Road",
                "Male",
                "Coloured",
                con);
        ResponseEntity<Teacher> postResponse = restTemplate.postForEntity(baseURL + "/create", teach, Teacher.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());


    }

    @Test
    public void update() {
        int persalNum = 216062241;
        Teacher teacher = restTemplate.getForObject(baseURL + "/teacher/"+persalNum, Teacher.class);

        restTemplate.put(baseURL + "/teacher/"+persalNum, Teacher.class);
        Teacher updated = restTemplate.getForObject(baseURL+ "/teacher/"+persalNum, Teacher.class);
        assertNotNull(updated);
    }

    @Test
    public void delete() {
        int persalNum = 216062241;
        Teacher obj = restTemplate.getForObject(baseURL + "/teacher/"+persalNum, Teacher.class);
        assertNotNull(obj);
        restTemplate.delete(baseURL+"/teacher/"+persalNum, Teacher.class);
        try {
            obj = restTemplate.getForObject(baseURL+"/teacher/"+persalNum, Teacher.class);
        }catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Teacher obj = restTemplate.getForObject(baseURL+"/teacher/216062241", Teacher.class);
        System.out.println(obj.getFirst_Name());
        assertNotNull(obj);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response =  restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    public void test1() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null , headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth("user", "password")
                .postForEntity(baseURL + "/test/1", entity, String.class);
        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }

    @Test
    public void testCreate() {
    }
}