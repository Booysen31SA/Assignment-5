package com.Booysen31SA.domain.appointment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Appointment implements Person, AppointmentToSee{

    private String persalNumber;
    private String appointmentToSee;

    public Appointment(Builder build){
        this.persalNumber = build.persalNumber;
        this.appointmentToSee = build.appointmentToSee;
    }

    public Appointment(String persalNumber, String appointmentToSee) {
        this.persalNumber = persalNumber;
        this.appointmentToSee = appointmentToSee;
    }

    @Override
    public String getAppointmentToSee() {
        return appointmentToSee;
    }

    @Override
    public String getPersalNumber() {
        return persalNumber;
    }


    public static class Builder{
        private String persalNumber;
        private String appointmentToSee;

        public Builder persalNumber(String persalNumber) {
            this.persalNumber = persalNumber;
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
                "persalNumber='" + persalNumber + '\'' +
                ", appointmentToSee='" + appointmentToSee + '\'' +
                '}';
    }
}
