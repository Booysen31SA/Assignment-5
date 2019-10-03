package com.Booysen31SA.services.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.repository.IRepository;
import com.Booysen31SA.services.IService;

import java.util.Set;

public interface IAppointmentService extends IService<Appointment, String> {

    Set<Appointment> getAll();
}
