package factory.appointmentFactory;

import domain.appointment.Apointment;

public class AppointmentFactory {

    public static Apointment addAppointment(String date, String time, String appFor, String reason, int persalNumber){

        return new Apointment.Builder().setdateOfAppointments(date)
                                        .setAppointmentSee(appFor)
                                        .setReason(reason)
                                        .setpersalNumber(persalNumber)
                                        .setTimeOfAppointment(time).build();
    }
}
