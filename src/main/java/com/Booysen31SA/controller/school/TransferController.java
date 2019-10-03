package com.Booysen31SA.controller.school;

import com.Booysen31SA.domain.ResponseObj;
import com.Booysen31SA.domain.school.Status;
import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.factory.ResponseObjFactory;
import com.Booysen31SA.factory.school.StatusFactory;
import com.Booysen31SA.factory.school.TransferFactory;
import com.Booysen31SA.services.school.impl.StatusRetirementServiceImpl;
import com.Booysen31SA.services.school.impl.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @Autowired
    @Qualifier("StatusSchoolServiceImpl")
    private StatusRetirementServiceImpl service2;

    public TransferController() {
        service = TransferServiceImpl.getService();
        service2 = StatusRetirementServiceImpl.getService();
    }

    @PostMapping(value = "/create")
    public ResponseEntity createA( @RequestBody TransferCreation transferCreation) {

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
               buildTransfer = TransferFactory.buildTransfer(transfer.getPersalNumber(), transfer.getPreviousSchool(), transfer.getSchoolName(), transfer.getTeacherAmount());
               buildStatus = StatusFactory.buildStatus(status.getPersal_Number(), status.getStatusRequest());

            service.create(buildTransfer);
            service2.create(buildStatus);

            responseObj.setResponse(transferCreation);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity read(@PathVariable String id){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Get Transfer!");

        Transfer buildTransfer = service.read(id);
        Status buildStatus = service2.read(id);

        if(buildTransfer == null){
            responseObj.setResponse(id);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("appointment Doesnt exist!");
        }else{
            TransferCreation transferCreation = new TransferCreation(buildTransfer, buildStatus);
            responseObj.setResponse(transferCreation);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value = "/update")
    public ResponseEntity update( @RequestBody TransferCreation transferCreation) {

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Transfer updated!");

        Transfer transfer = transferCreation.getTransfer();
        Status status = transferCreation.getStatus();

        Transfer buildTransfer;
        Status buildStatus;

        Transfer checkTransfer = service.read(transfer.getPersalNumber());
        if(checkTransfer == null){
            responseObj.setResponse(transferCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Transfer dont exist!");
        }else {
            buildTransfer = TransferFactory.buildTransfer(transfer.getPersalNumber(), transfer.getPreviousSchool(), transfer.getSchoolName(), transfer.getTeacherAmount());
            buildStatus = StatusFactory.buildStatus(status.getPersal_Number(), status.getStatusRequest());

            service.update(buildTransfer);
            service2.update(buildStatus);

            responseObj.setResponse(transferCreation);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete Transfer!");

        Transfer buildTransfer = service.read(id);
        Status buildStatus = service2.read(id);

        if(buildTransfer == null){
            responseObj.setResponse(id);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("appointment Doesnt exist!");
        }else{
            TransferCreation transferCreation = new TransferCreation(buildTransfer, buildStatus);

            service.delete(buildTransfer.getPersalNumber());
            service2.delete(buildStatus.getPersal_Number());
            responseObj.setResponse(transferCreation);
        }
        return ResponseEntity.ok(responseObj);
    }
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Transfer> genders = service.getAll();
        responseObj.setResponse(genders);
        return ResponseEntity.ok(responseObj);
    }
    }
