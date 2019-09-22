package com.Booysen31SA.factory.appointment;

import com.Booysen31SA.domain.appointment.Appointment;

public class AppointmentFactory {
    public static Appointment buildAppointment(String persal_Number, String appointmentToSee){
        return new Appointment.Builder()
                .persal_Number(persal_Number)
                .appointmentToSee(appointmentToSee)
                .build();
    }
}