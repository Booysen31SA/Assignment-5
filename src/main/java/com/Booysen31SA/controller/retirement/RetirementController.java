package com.Booysen31SA.controller.retirement;

import com.Booysen31SA.domain.ResponseObj;
import com.Booysen31SA.domain.retirement.Retirement;
import com.Booysen31SA.domain.retirement.Status;
import com.Booysen31SA.factory.ResponseObjFactory;
import com.Booysen31SA.factory.retirement.RetirementFactory;
import com.Booysen31SA.factory.retirement.StatusFactory;
import com.Booysen31SA.services.retirement.impl.RetirementServiceImpl;
import com.Booysen31SA.services.retirement.impl.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/retirement")
public class RetirementController {

    @GetMapping("/test/{id}")
    @ResponseBody
    public String test(@PathVariable String id) {
        if(id.equalsIgnoreCase("1")){
            return "Correct ID";
        }else{
            return "Wrong";
        }
    }

    @Autowired
    @Qualifier("RetirementServiceImpl")
    private RetirementServiceImpl service;
    @Qualifier("StatusRetirementServiceImpl")
    private StatusServiceImpl service2;

    public RetirementController() {
        service = RetirementServiceImpl.getService();
        service2 = StatusServiceImpl.getService();
    }

    @PostMapping(value = "/create")
    public ResponseEntity createA( @RequestBody RetirementCreation retirementCreation){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Retirement Created created!");

        Retirement retirement = retirementCreation.getRetirement();
        Status status = retirementCreation.getStatus();

        Retirement buildRetirement;
        Status buildStatus;

        if(retirement == null){
            responseObj.setResponse(retirementCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide an retirement!");
        }else {
            buildRetirement = RetirementFactory.buildRetirement(retirement.getPersal_Num(), retirement.getiD(), retirement.getFirstName(), retirement.getLastName(), retirement.getPayout());
            buildStatus = StatusFactory.buildStatus(retirement.getPersal_Num(), status.getRequest());

            service.create(buildRetirement);
            service2.create(buildStatus);

            responseObj.setResponse(retirementCreation);
        }
        return ResponseEntity.ok(responseObj);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity read(@PathVariable String id){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Get Retirement!");

        Retirement retirement = service.read(id);
        Status status = service2.read(id);

        if(retirement == null){
            responseObj.setResponse(id);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Retirement Doesnt exist!");
        }else{
            RetirementCreation retirementCreation = new RetirementCreation(retirement, status);
            responseObj.setResponse(retirementCreation);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value = "/update")
    public ResponseEntity update( @RequestBody RetirementCreation retirementCreation){


        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Retirement Updated!");

        Retirement retirement = retirementCreation.getRetirement();
        Status status = retirementCreation.getStatus();

        Retirement buildRetirement;
        Status buildStatus;

        Retirement retirement1 = service.read(retirement.getPersal_Num());
        if(retirement1 == null){
            responseObj.setResponse(retirementCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Retirement dont exist!");
        }else {
            buildRetirement = RetirementFactory.buildRetirement(retirement.getPersal_Num(), retirement.getiD(), retirement.getFirstName(), retirement.getLastName(), retirement.getPayout());
            buildStatus = StatusFactory.buildStatus(retirement.getPersal_Num(), status.getRequest());

            service.update(buildRetirement);
            service2.update(buildStatus);

            responseObj.setResponse(retirementCreation);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete Retirement!");

        Retirement retirement = service.read(id);
        Status status = service2.read(id);

        if(retirement == null){
            responseObj.setResponse(id);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Retirement Doesnt exist!");
        }else{
            RetirementCreation retirementCreation = new RetirementCreation(retirement, status);
            service.delete(retirement.getPersal_Num());
            service2.delete(status.getPersal_Number());

            responseObj.setResponse(retirementCreation);
        }
        return ResponseEntity.ok(responseObj);
    }

}
