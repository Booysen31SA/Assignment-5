package com.Booysen31SA.controller.teacher;

import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.services.teacher.users.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

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
    @Qualifier("UserServiceImpl")
    private UserServiceImpl service;

    @PostMapping("/create")
    public User create(@RequestBody User User){
        return service.create(User);
    }

    @PostMapping("/update")
    @ResponseBody
    public User update(User User){
        return service.update(User);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public User read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<User> getAll() {
        return service.getAll();
    }
}