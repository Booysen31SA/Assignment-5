package com.Booysen31SA.controller.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.domain.appointment.DateAndTime;
import com.Booysen31SA.domain.appointment.Reason;
import com.Booysen31SA.factory.appointment.AppointmentFactory;

public class AppointmentCreation {
    private Appointment appointment;
    private DateAndTime dateAndTime;
    private Reason reason;

    public Appointment getAppointment() {
        return appointment;
    }

    public DateAndTime getDateAndTime() {
        return dateAndTime;
    }

    public Reason getReason() {
        return reason;
    }

    public AppointmentCreation() {
    }

    public AppointmentCreation(Appointment appointment, DateAndTime dateAndTime, Reason reason){
          this.appointment = AppointmentFactory.buildAppointment(appointment.getPersalNumber(), appointment.getAppointmentToSee());
          this.dateAndTime = dateAndTime;
          this.reason = reason;
    }

}
