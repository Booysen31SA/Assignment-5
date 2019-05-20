package com.Booysen31SA.controller.school;

import com.Booysen31SA.domain.school.Transfer;
import com.Booysen31SA.services.impl.school.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    @Qualifier("TransferServiceImpl")
    private TransferService service;

    @PostMapping("/create")
    @ResponseBody
    public Transfer create(Transfer transfer){
        return service.create(transfer);
    }

    @PostMapping("/update")
    @ResponseBody
    public Transfer update(Transfer transfer){
        return service.update(transfer);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Transfer read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Transfer> getAll() {
        return service.getAll();
    }
}
