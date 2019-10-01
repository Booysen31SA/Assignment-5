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

    @PostMapping(value = "/create")
    public ResponseEntity createA( @RequestBody RetirementCreation retirementCreation){
        service = RetirementServiceImpl.getService();
        service2 = StatusServiceImpl.getService();

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

}
