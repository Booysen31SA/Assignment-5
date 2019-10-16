package com.Booysen31SA.controller.teacher;

import com.Booysen31SA.controller.school.TransferCreation;
import com.Booysen31SA.domain.teacher.user.Role.UserRole;
import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.domain.teacher.user.address.Address;
import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
import com.Booysen31SA.factory.teacher.user.Role.UserRoleFactory;
import com.Booysen31SA.factory.teacher.user.UserFactory;
import com.Booysen31SA.factory.teacher.user.address.AddressFactory;
import com.Booysen31SA.factory.teacher.user.appointed.DateAppointedFactory;
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
public class TeacherControllerTest {

    private static final String BASE_URL = "http://localhost:8080/teacher";

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
    private TeacherCreation teacherCreation;


    @Test
    public void create() throws Exception{
        User user = UserFactory.buildUser("216062241","51515415458L", "Matthew","Booysen");
        Address address = AddressFactory.buildAddress("216062241", "scsdcsd", "scsdcs");
        DateAppointed dateAppointed = DateAppointedFactory.buildDateAppointed("216062241", "17/02/2020");
        UserRole userRole = UserRoleFactory.BuildUserRole("216062241", "admin", "password");
        teacherCreation = new TeacherCreation(user, dateAppointed, address,userRole);

        String inputJson = mapToJson(teacherCreation);
        URI uri = new URI(BASE_URL+"/create");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<TeacherCreation> request = new HttpEntity<>(teacherCreation, headers);

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
        User user = UserFactory.buildUser("216062241","51515415458L", "Matthew","Booysen");
        Address address = AddressFactory.buildAddress("216062241", "32 South Road", "32 South Road");
        DateAppointed dateAppointed = DateAppointedFactory.buildDateAppointed("216062241", "17/02/2020");
        UserRole userRole = UserRoleFactory.BuildUserRole("216062241", "admin", "password");
        teacherCreation = new TeacherCreation(user, dateAppointed, address,userRole);

        String inputJson = mapToJson(teacherCreation);
        URI uri = new URI(BASE_URL+"/update");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<TeacherCreation> request = new HttpEntity<>(teacherCreation, headers);

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