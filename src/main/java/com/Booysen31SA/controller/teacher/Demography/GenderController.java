package com.Booysen31SA.controller.teacher.Demography;

import com.Booysen31SA.domain.ResponseObj;
import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.factory.ResponseObjFactory;
import com.Booysen31SA.factory.teacher.demography.GenderFactory;
import com.Booysen31SA.services.teacher.demography.impl.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/gender")
public class GenderController {
    @Autowired
    GenderService genderService;

    @PostMapping(value = "/create/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createGender(@PathVariable String gender) {
        System.out.println("Entered Value: " + gender);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Gender created!");
        Gender savedGender;
        if (gender == null || gender.trim().isEmpty() || gender.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a gender!");
        } else {
            savedGender = genderService.getByName(gender);
            if (savedGender != null) {
                responseObj.setResponseDescription("Gender already exist!");
            } else {
                savedGender = GenderFactory.buildGender(gender);
                savedGender = genderService.create(savedGender);
            }
            responseObj.setResponse(savedGender);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Gender> genders = genderService.getAll();
        responseObj.setResponse(genders);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity read(@PathVariable String id){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Gender genders = genderService.getByName(id);
        responseObj.setResponse(genders);
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value = "/update/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateGender(@PathVariable String gender) {
        System.out.println("Entered Value: " + gender);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Gender updated!");
        Gender savedGender;
        Gender checkGender = genderService.getByName(gender);
        if (checkGender == null || gender.trim().isEmpty() || gender.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a gender!");
        } else {
            savedGender = genderService.getByName(gender);
            if (savedGender != null) {
                responseObj.setResponseDescription("Gender already exist!");
            } else {
                savedGender = GenderFactory.buildGender(gender);
                savedGender = genderService.update(savedGender);
            }
            responseObj.setResponse(savedGender);
        }
        return ResponseEntity.ok(responseObj);
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Gender genders = genderService.getByName(id);
        genderService.delete(genders.getGenderId());
        responseObj.setResponse(genders);
        return ResponseEntity.ok(responseObj);
    }
}