package com.Booysen31SA.factory.appointment;

import com.Booysen31SA.domain.appointment.Appointment;

public class AppointmentFactory {
    public static Appointment buildAppointment(String persalNumber, String appointmentToSee){
        return new Appointment.Builder()
                .persalNumber(persalNumber)
                .appointmentToSee(appointmentToSee)
                .build();
    }
}