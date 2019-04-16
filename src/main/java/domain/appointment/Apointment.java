package domain.appointment;

public class Apointment implements Person, AppointmentSee{

    DateAndTime dat;
    Reason reason;
    private int persalNumber;
    private String appointmentSee;


    public Apointment(Builder build) {
        this.persalNumber = build.persalNumber;
        this.appointmentSee = build.appointmentSee;
      dat = new DateAndTime(build.dateOfAppointments, build.timeOfAppointments);
      reason = new Reason(build.reasonForAppointment);
    }

    @Override
    public int getPersalNumber() {
        return persalNumber;
    }

    @Override
    public String getAppointmentSee() {
      return appointmentSee;
    }

    public static class Builder{

        private String dateOfAppointments;
        private String timeOfAppointments;
        private String appointmentSee;
        private String reasonForAppointment;
        private int persalNumber;

        public Builder setTimeOfAppointment(String time){
            this.timeOfAppointments = time;
            return this;
        }

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


        public Builder setAppointmentSee(String appointmentSee){
            this.appointmentSee = appointmentSee;
            return this;
        }

        public Apointment build() {
            return new Apointment(this);
        }
    }

    @Override
    public String toString() {
        return "\nDate   :" +dat.getDate()+
                "\nTime  :" +dat.getTime()+
                "\nTo See:" +appointmentSee+
                "\nReason:" +reason.getReason()+
                "\nVistor:" +persalNumber
                     ;
    }
}
