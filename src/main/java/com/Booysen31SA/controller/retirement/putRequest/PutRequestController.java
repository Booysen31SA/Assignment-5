package com.Booysen31SA.controller.retirement.putRequest;

import com.Booysen31SA.domain.retirement.PutRequest;
import com.Booysen31SA.repository.impl.retirement.putRequest.PutRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/put")
public class PutRequestController {

    @Autowired
    private PutRequestRepository service;

    @PostMapping("/create")
    @ResponseBody
    public PutRequest create(PutRequest putRequest){
        return service.create(putRequest);
    }

    @PostMapping("/update")
    @ResponseBody
    public PutRequest update(PutRequest putRequest){
        return service.update(putRequest);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public PutRequest read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<PutRequest> getAll() {
        return service.getAll();
    }
}
