package com.Booysen31SA.repository.impl.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private static AppointmentRepositoryImpl repository = null;
    private Map<Integer, Appointment> appointments;

    private AppointmentRepositoryImpl(){
        this.appointments = new HashMap<>();
    }

    public static AppointmentRepositoryImpl getAppointment(){
        if(repository == null) repository = new AppointmentRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Appointment> getAll() {
        Collection<Appointment> app = this.appointments.values();
        Set<Appointment> set = new HashSet<>();
        set.addAll(app);
        return set;
    }

    @Override
    public Appointment create(Appointment appointment) {
         this.appointments.put(appointment.getPersalNumber(), appointment);
         return appointment;
    }

    @Override
    public Appointment update(Appointment appointment) {
        this.appointments.replace(appointment.getPersalNumber(), appointment);
        return appointment;
    }

    @Override
    public void delete(Integer id) {
      this.appointments.remove(id);
    }

    @Override
    public Appointment read(Integer id) {
        return this.appointments.get(id);
    }

}
