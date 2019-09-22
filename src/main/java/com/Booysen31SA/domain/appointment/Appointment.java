package com.Booysen31SA.domain.appointment;

public class Appointment implements Person, AppointmentToSee{

    private String persal_Number;
    private String appointmentToSee;

    public Appointment(Builder build){
        this.persal_Number = build.persal_Number;
        this.appointmentToSee = build.appointmentToSee;
    }
    @Override
    public String getAppointmentToSee() {
        return appointmentToSee;
    }

    @Override
    public String getPersalNumber() {
        return persal_Number;
    }

    public static class Builder{
        private String persal_Number;
        private String appointmentToSee;

        public Builder persal_Number(String persal_Number) {
            this.persal_Number = persal_Number;
            return this;
        }
        public Builder appointmentToSee(String appointmentToSee) {
            this.appointmentToSee = appointmentToSee;
            return this;
        }
        public Appointment build() {
            return new Appointment(this);
        }
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "persal_Number='" + persal_Number + '\'' +
                ", appointmentToSee='" + appointmentToSee + '\'' +
                '}';
    }
}
