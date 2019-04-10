package domain.Appointments;

public class Apointment {

    private String dateOfAppointments;
    private String appointmentFor;

    public Apointment(Builder buid) {
        this.dateOfAppointments = buid.dateOfAppointments;
        this.appointmentFor = buid.appointmentFor;
    }

    public static class Builder{

        private String dateOfAppointments;
        private String appointmentFor;

        public Builder seAppointmentFor(String dateOfAppointments){
            this.dateOfAppointments = dateOfAppointments;
            return this;
        }


        public Builder setAppointmentFor(String appointmentFor){
            this.appointmentFor = appointmentFor;
            return this;
        }

        public Apointment build() {
            return new Apointment(this);
        }
    }
}
