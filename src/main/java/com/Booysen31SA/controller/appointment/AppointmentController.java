package com.Booysen31SA.controller.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.services.impl.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping("/create")
    @ResponseBody
    public Appointment create(Appointment appointment){
        return service.create(appointment);
    }

    @PostMapping("/update")
    @ResponseBody
    public Appointment update(Appointment appointment){
        return service.update(appointment);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Appointment read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Appointment> getAll() {
        return service.getAll();
    }
}
