package com.Booysen31SA.controller.school;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.services.school.impl.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @PostMapping("/create")
    public Transfer create(@RequestBody Transfer Transfer){
        return service.create(Transfer);
    }

    @PostMapping("/update")
    @ResponseBody
    public Transfer update(Transfer Transfer){
        return service.update(Transfer);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Transfer read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Transfer> getAll() {
        return service.getAll();
    }
}
