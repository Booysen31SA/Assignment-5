package domain.Appointments;

public class Apointment implements Person{

    DateAndTime dat;
    Reasons reason;
    private int persalNumber;


    public Apointment(Builder build) {
        this.persalNumber = build.persalNumber;
      dat = new DateAndTime(build.dateOfAppointments, build.timeOfAppointments);
      reason = new Reasons(build.reasonForAppointment);
    }

    @Override
    public int getPersalNumber() {
        return persalNumber;
    }

    public static class Builder{

        private String dateOfAppointments;
        private String timeOfAppointments;
        private String appointmentFor;
        private String reasonForAppointment;
        private int persalNumber;

        public Builder setpersalNumber(int persal){
            this.persalNumber = persal;
            return this;
        }

        public Builder setdateOfAppointments(String dateOfAppointments){
            this.dateOfAppointments = dateOfAppointments;
            return this;
        }

        public Builder setReason(String reason){
            this.reasonForAppointment = reason;
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
