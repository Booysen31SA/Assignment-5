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
    @Qualifier("StatusSchoolServiceImpl")
    private StatusServiceImpl service2;

    @PostMapping(value = "/create")
    public ResponseEntity createA( @RequestBody TransferCreation transferCreation) {

        service = TransferServiceImpl.getService();
        service2 = StatusServiceImpl.getService();

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Transfer Created created!");

        Transfer transfer = transferCreation.getTransfer();
        Status status = transferCreation.getStatus();

        Transfer buildTransfer;
        Status buildStatus;

        if(transfer == null){
            responseObj.setResponse(transferCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide an Transfer!");
        }else {
               buildTransfer = TransferFactory.buildTransfer("216062241", "SP", "mat", 80000);
               buildStatus = StatusFactory.buildStatus("216062241", "New");

            service.create(buildTransfer);
            service2.create(buildStatus);

            responseObj.setResponse(transferCreation);
        }
        return ResponseEntity.ok(responseObj);
    }
    }
