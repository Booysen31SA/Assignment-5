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
    private StatusServiceImpl service2;

    @PostMapping(value = "/create/{persalNumber}/{id}/{firstName}/{lastName}/{payout}/{status}")
    public ResponseEntity create(@PathVariable String persalNumber, @PathVariable long id, @PathVariable String firstName, @PathVariable String lastName, @PathVariable double payout, @PathVariable String status){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Retirement created!");
        Retirement app = service.read(persalNumber.trim());
        Status dat = service2.read(persalNumber.trim());

        if(app == null || dat == null){
            responseObj.setResponseDescription("Retirement already exist!");
        }else{
            Retirement app2 = RetirementFactory.buildRetirement(persalNumber, id, firstName,lastName,payout);
            Status dat2 = StatusFactory.buildStatus(persalNumber, status);

            service.create(app2);
            service2.create(dat2);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value = "/update/{persalNumber}/{id}/{firstName}/{lastName}/{payout}/{status}")
    public ResponseEntity updated(@PathVariable String persalNumber, @PathVariable long id, @PathVariable String firstName, @PathVariable String lastName, @PathVariable double payout, @PathVariable String status){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Retirement updated!");
        Retirement app = service.read(persalNumber.trim());
        Status dat = service2.read(persalNumber.trim());

        if(app == null || dat == null){
            responseObj.setResponseDescription("Retirement already exist!");
        }else{
            Retirement app2 = RetirementFactory.buildRetirement(persalNumber, id, firstName,lastName,payout);
            Status dat2 = StatusFactory.buildStatus(persalNumber, status);

            service.update(app2);
            service2.update(dat2);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping("/delete/{persalNumber}")
    public ResponseEntity delete(@PathVariable String persalNumber){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Retirement Delete!");
        Retirement app = service.read(persalNumber.trim());
        if(app == null){
            responseObj.setResponseDescription("Retirement Dont exist!");
        }else{
            service.delete(persalNumber);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping("/read/{persalNumber}")
    public ResponseEntity read(@PathVariable String persalNumber){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Retirement created!");
        Retirement app = service.read(persalNumber.trim());
        if(app == null){
            responseObj.setResponseDescription("Retirement Dont exist!");
        }else{
            app = service.read(persalNumber);
        }
        return ResponseEntity.ok(app);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Retirement> getAll() {
        return service.getAll();
    }
}
