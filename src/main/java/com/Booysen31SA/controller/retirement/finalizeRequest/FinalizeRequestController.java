package com.Booysen31SA.controller.retirement.finalizeRequest;

import com.Booysen31SA.domain.retirement.FinalizeRequest;
import com.Booysen31SA.services.impl.retirement.finalizeRequest.FinalizeRequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/final")
public class FinalizeRequestController {

    @Autowired
    @Qualifier("FinalizeRequestServiceImpl")
    private FinalizeRequestServiceImpl service;

    @PostMapping("/create")
    public FinalizeRequest create(@RequestBody FinalizeRequest finalizeRequest){
        return service.create(finalizeRequest);
    }

    @PostMapping("/update")
    @ResponseBody
    public FinalizeRequest update(FinalizeRequest finalizeRequest){
        return service.update(finalizeRequest);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public FinalizeRequest read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<FinalizeRequest> getAll() {
        return service.getAll();
    }
}
