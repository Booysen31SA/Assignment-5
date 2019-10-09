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
    @Autowired
    @Qualifier("StatusRetirementServiceImpl")
    private StatusServiceImpl service2;

    public RetirementController() {
        service = RetirementServiceImpl.getService();
        service2 = StatusServiceImpl.getService();
    }

    @PostMapping(value = "/create")
    public RetirementCreation createA( @RequestBody RetirementCreation retirementCreation){

        Retirement retirement = retirementCreation.getRetirement();
        Status status = retirementCreation.getStatus();

        Retirement buildRetirement;
        Status buildStatus;
         Retirement check = service.read(retirement.getPersal_Num());
        if(retirement == null){
            buildRetirement = RetirementFactory.buildRetirement(null, null, null,null, 0);
            buildStatus = StatusFactory.buildStatus(null, null);
        }else{
            buildRetirement = RetirementFactory.buildRetirement(retirement.getPersal_Num(), retirement.getiD(), retirement.getFirstName(), retirement.getLastName(), retirement.getPayout());
            buildStatus = StatusFactory.buildStatus(retirement.getPersal_Num(), status.getRequest());

            service.create(buildRetirement);
            service2.create(buildStatus);
        }
        return new RetirementCreation(retirementCreation.getRetirement(), retirementCreation.getStatus());
    }
    @GetMapping("/read/{id}")
    public RetirementCreation read(@PathVariable String id){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Get Retirement!");

        Retirement retirement = service.read(id);
        Status status = service2.read(id);

        if(retirement == null){
            retirement = RetirementFactory.buildRetirement(retirement.getPersal_Num(), retirement.getiD(), retirement.getFirstName(), retirement.getLastName(), retirement.getPayout());
            status = StatusFactory.buildStatus(retirement.getPersal_Num(), status.getRequest());
        }else{
            retirement = RetirementFactory.buildRetirement(retirement.getPersal_Num(), retirement.getiD(), retirement.getFirstName(), retirement.getLastName(), retirement.getPayout());
            status = StatusFactory.buildStatus(retirement.getPersal_Num(), status.getRequest());
            RetirementCreation retirementCreation = new RetirementCreation(retirement, status);
        }
        return new RetirementCreation(retirement, status);
    }

    @PostMapping(value = "/update")
    public RetirementCreation update( @RequestBody RetirementCreation retirementCreation){

        Retirement retirement = retirementCreation.getRetirement();
        Status status = retirementCreation.getStatus();

        Retirement buildRetirement;
        Status buildStatus;
        Retirement check = service.read(retirement.getPersal_Num());
        if(retirement == null){

        }else if(check != null){
            buildRetirement = RetirementFactory.buildRetirement(null, null, null, null, 0);
            buildStatus = StatusFactory.buildStatus(null, null);
        }  else{
            buildRetirement = RetirementFactory.buildRetirement(retirement.getPersal_Num(), retirement.getiD(), retirement.getFirstName(), retirement.getLastName(), retirement.getPayout());
            buildStatus = StatusFactory.buildStatus(retirement.getPersal_Num(), status.getRequest());

            service.update(buildRetirement);
            service2.update(buildStatus);

        }
        return new RetirementCreation(retirementCreation.getRetirement(), retirementCreation.getStatus());
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable String id){

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
    }

    @GetMapping(value = "/getall/retirement", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Retirement> getAllRetirements(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Retirement> genders = service.getAll();
        responseObj.setResponse(genders);
        return genders;
    }
    @GetMapping(value = "/getall/retirementStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Status> getAllRetirementStatus(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Status> genders = service2.getAll();
        responseObj.setResponse(genders);
        return genders;
    }
}
