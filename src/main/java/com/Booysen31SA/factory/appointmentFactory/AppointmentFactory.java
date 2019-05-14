package com.Booysen31SA.factory.appointmentFactory;

import com.Booysen31SA.domain.appointment.Appointment;

public class AppointmentFactory {

    public static Appointment addAppointment(String date, String time, String appFor, String reason, int persalNumber){

        return new Appointment.Builder().setdateOfAppointments(date)
                                        .setAppointmentSee(appFor)
                                        .setReason(reason)
                                        .setpersalNumber(persalNumber)
                                        .setTimeOfAppointment(time).build();
    }
}
