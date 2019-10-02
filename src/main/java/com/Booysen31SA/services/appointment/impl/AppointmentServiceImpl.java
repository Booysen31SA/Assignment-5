package com.Booysen31SA.services.appointment.impl;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.repository.appointment.IAppointmentRepository;
import com.Booysen31SA.repository.appointment.impl.AppointmentRepositoryImpl;
import com.Booysen31SA.services.appointment.IAppointmentService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service("AppointmentServiceImpl")
public class AppointmentServiceImpl implements IAppointmentService {

    private static AppointmentServiceImpl service = null;
    private IAppointmentRepository repository;

    public AppointmentServiceImpl(){
        repository = AppointmentRepositoryImpl.getAppointmentRepository();
    }
    public static AppointmentServiceImpl getService(){
        if(service == null){
            return new AppointmentServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Appointment> getAll() {
        return repository.getAll();
    }

    @Override
    public Appointment create(Appointment appointment) {
        return repository.create(appointment);
    }

    @Override
    public Appointment read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return repository.update(appointment);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}
