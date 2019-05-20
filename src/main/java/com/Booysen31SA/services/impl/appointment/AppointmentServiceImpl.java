package com.Booysen31SA.services.impl.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.repository.impl.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AppointmentServiceImpl")
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public Set<Appointment> getAll() {
        return repository.getAll();
    }

    @Override
    public Appointment create(Appointment appointment) {
        return repository.create(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
       return repository.update(appointment);
    }

    @Override
    public void delete(Integer integer) {
      repository.delete(integer);
    }

    @Override
    public Appointment read(Integer integer) {
        return repository.read(integer);
    }
}
