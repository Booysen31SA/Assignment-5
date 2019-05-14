package com.Booysen31SA.services.impl.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.services.impl.IService;

import java.util.Set;

public interface AppointmentService extends IService<Appointment, Integer> {
    Set<Appointment> getAll();
}
