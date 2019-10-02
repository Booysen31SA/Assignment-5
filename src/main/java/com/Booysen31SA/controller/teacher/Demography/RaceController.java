package com.Booysen31SA.controller.teacher.Demography;

import com.Booysen31SA.domain.ResponseObj;
import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.factory.ResponseObjFactory;
import com.Booysen31SA.factory.teacher.demography.RaceFactory;
import com.Booysen31SA.services.teacher.demography.impl.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/race")
public class RaceController {

    @Autowired
    private RaceService raceService;

    @PostMapping(value = "/create/{race}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRace(@PathVariable String race) {
        System.out.println("Entered Value: " + race);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Race created!");
        Race savedRace;
        if (race == null || race.trim().isEmpty() || race.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a race!");
        } else {
            savedRace = raceService.getByName(race);
            if (savedRace != null) {
                responseObj.setResponseDescription("Race already exist!");
            } else {
                savedRace = RaceFactory.buildRace(race);
                savedRace = raceService.create(savedRace);
            }
            responseObj.setResponse(savedRace);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Race> races = raceService.getAll();
        responseObj.setResponse(races);
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity read(@PathVariable String id){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Race race = raceService.getByName(id);
        responseObj.setResponse(race);
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value = "/update/{race}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateRace(@PathVariable String race) {
        System.out.println("Entered Value: " + race);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Race updated!");
        Race savedRace;

        Race checkRace = raceService.getByName(race);
        if (checkRace == null || race.trim().isEmpty() || race.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a race!");
        } else {
            savedRace = raceService.getByName(race);
            if (savedRace != null) {
                responseObj.setResponseDescription("Race already exist!");
            } else {
                savedRace = RaceFactory.buildRace(race);
                savedRace = raceService.update(savedRace);
            }
            responseObj.setResponse(savedRace);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Race race = raceService.getByName(id);
        raceService.delete(race.getRaceId());
        responseObj.setResponse(race);
        return ResponseEntity.ok(responseObj);
    }
}
