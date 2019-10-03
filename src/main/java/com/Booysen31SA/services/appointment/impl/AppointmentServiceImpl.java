package com.Booysen31SA.services.appointment.impl;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.repository.appointment.IAppointmentRepository;
import com.Booysen31SA.services.appointment.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("AppointmentServiceImpl")
public class AppointmentServiceImpl implements IAppointmentService {

    private static AppointmentServiceImpl service = null;
    @Autowired
    private IAppointmentRepository repository;

    public AppointmentServiceImpl(){
    }
    public static AppointmentServiceImpl getService(){
        if(service == null){
            return new AppointmentServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Appointment> getAll() {
        List<Appointment> list = (List<Appointment>) repository.findAll();
        return  new HashSet<>(list);
    }

    @Override
    public Appointment create(Appointment appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public Appointment read(String integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public void delete(String integer) {
        this.repository.deleteById(integer);
    }
}
