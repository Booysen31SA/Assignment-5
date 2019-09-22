package com.Booysen31SA.controller.school;

import com.Booysen31SA.domain.ResponseObj;
import com.Booysen31SA.domain.school.Status;
import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.factory.ResponseObjFactory;
import com.Booysen31SA.factory.school.StatusFactory;
import com.Booysen31SA.factory.school.TransferFactory;
import com.Booysen31SA.services.school.impl.StatusServiceImpl;
import com.Booysen31SA.services.school.impl.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/transfer")
public class TransferController {

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
    @Qualifier("TransferServiceImpl")
    private TransferServiceImpl service;
    private StatusServiceImpl service2;

    @PostMapping(value = "/create/{persalNumber}/{previousSchool}/{schoolName}/{teacherAmount}/{statusRequest}")
    public ResponseEntity create(@PathVariable String persalNumber, @PathVariable String previousSchool, @PathVariable String schoolName, @PathVariable int teacherAmount, @PathVariable String statusRequest){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Transfer created!");
        Transfer app = service.read(persalNumber.trim());
        Status dat = service2.read(persalNumber.trim());

        if(app == null || dat == null){
            responseObj.setResponseDescription("Transfer already exist!");
        }else{
            Transfer app2 = TransferFactory.buildTransfer(persalNumber, previousSchool, schoolName,teacherAmount);
            Status dat2 = StatusFactory.buildStatus(persalNumber, statusRequest);

            service.create(app2);
            service2.create(dat2);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value = "/create/{persalNumber}/{id}/{firstName}/{lastName}/{payout}/{status}")
    public ResponseEntity updated(@PathVariable String persalNumber, @PathVariable String previousSchool, @PathVariable String schoolName, @PathVariable int teacherAmount, @PathVariable String statusRequest){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Transfer updated!");
        Transfer app = service.read(persalNumber.trim());
        Status dat = service2.read(persalNumber.trim());

        if(app == null || dat == null){
            responseObj.setResponseDescription("Transfer already exist!");
        }else{
            Transfer app2 = TransferFactory.buildTransfer(persalNumber, previousSchool, schoolName,teacherAmount);
            Status dat2 = StatusFactory.buildStatus(persalNumber, statusRequest);

            service.update(app2);
            service2.update(dat2);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping("/delete/{persalNumber}")
    public ResponseEntity delete(@PathVariable String persalNumber){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Transfer Delete!");
        Transfer app = service.read(persalNumber.trim());
        if(app == null){
            responseObj.setResponseDescription("Transfer Dont exist!");
        }else{
            service.delete(persalNumber);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping("/read/{persalNumber}")
    public ResponseEntity read(@PathVariable String persalNumber){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Transfer created!");
        Transfer app = service.read(persalNumber.trim());
        if(app == null){
            responseObj.setResponseDescription("Transfer Dont exist!");
        }else{
            app = service.read(persalNumber);
        }
        return ResponseEntity.ok(app);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Transfer> getAll() {
        return service.getAll();
    }
}
