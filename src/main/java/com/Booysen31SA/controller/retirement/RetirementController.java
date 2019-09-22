package com.Booysen31SA.controller.retirement;

import com.Booysen31SA.domain.retirement.Retirement;
import com.Booysen31SA.services.retirement.impl.RetirementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @PostMapping("/create")
    public Retirement create(@RequestBody Retirement Retirement){
        return service.create(Retirement);
    }

    @PostMapping("/update")
    @ResponseBody
    public Retirement update(Retirement Retirement){
        return service.update(Retirement);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Retirement read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Retirement> getAll() {
        return service.getAll();
    }
}
