package com.Booysen31SA.controller.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.services.appointment.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

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
        @Qualifier("AppointmentServiceImpl")
        private AppointmentServiceImpl service;

        @PostMapping("/create")
        public Appointment create(@RequestBody Appointment appointment){
            return service.create(appointment);
        }

        @PostMapping("/update")
        @ResponseBody
        public Appointment update(Appointment appointment){
            return service.update(appointment);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id){
            service.delete(id);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public Appointment read(@PathVariable String id) {
            return service.read(id);
        }

        @GetMapping("/read/all")
        @ResponseBody
        public Set<Appointment> getAll() {
            return service.getAll();
        }
    }
