package com.Booysen31SA.repository.appointment.impl;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.repository.appointment.IAppointmentRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;


@Repository("AppointmentInMemory")
public class AppointmentRepositoryImpl implements IAppointmentRepository {

    private Set<Appointment> AppointmentDB;
    private static AppointmentRepositoryImpl AppointmentRepository = null;

    public AppointmentRepositoryImpl() {
        this.AppointmentDB = new HashSet<Appointment>();
    }

    public static AppointmentRepositoryImpl getAppointmentRepository() {
        if (AppointmentRepository == null) {
            return new AppointmentRepositoryImpl();
        }
        return AppointmentRepository;
    }

    @Override
    public Appointment create(Appointment appointment) {
       if(read(appointment.getPersalNumber()) == null){
          AppointmentDB.add(appointment);
       }
       return appointment;
    }

    @Override
    public Appointment read(String s) {
        return AppointmentDB.stream().filter(appointment ->
                                                  appointment.getPersalNumber().trim()
                                                          .equalsIgnoreCase(s))
                                                                                    .findAny()
                                                                                    .orElse(null);

    }

    @Override
    public Appointment update(Appointment appointment) {
        if(read(appointment.getPersalNumber()) != null){
            delete(appointment.getPersalNumber());
            create(appointment);
        }
        return appointment;
    }

    @Override
    public void delete(String s) {
        Appointment appointment = read(s);
        if(appointment != null){
            AppointmentDB.remove(appointment);
        }
    }

    @Override
    public Set<Appointment> getAll() {
        return AppointmentDB;
    }
}
