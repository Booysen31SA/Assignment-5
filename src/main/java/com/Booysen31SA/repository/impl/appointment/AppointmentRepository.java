package com.Booysen31SA.repository.impl.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.repository.impl.IRepository;

import java.util.Set;

public interface AppointmentRepository extends IRepository<Appointment, Integer> {
    Set<Appointment> getAll();
}
