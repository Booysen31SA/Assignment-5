package domain.retirement;

public class PutRequest extends Retirement implements RetirementIdentity, RetirementNames, Payout{

    Status status;

    public PutRequest(Builder build) {
        this.pasalNumber = build.pasalNumber;
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.payout = build.payout;
        this.id = build.id;
       request = build.status;
    }

    @Override
    public int getPersal_Num() {
        return pasalNumber;
    }

    @Override
    public String getiD() {
        return id;
    }


    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public double getPayOut() {
        return payout;
    }


    @Override
    public double getPayout() {
        return payout;
    }

    public static class Builder{

        private int pasalNumber;
        private String id;
        private String firstName;
        private String lastName;
        private double payout;
        private String status;

        public Builder setStatus(String status){
            this.status = status;
            return this;
        }
        public Builder setPayout(double payout){
            this.payout = payout;
            return this;
        }
        public Builder setLastName(String lName){
            this.lastName = lName;
            return this;
        }
        public Builder setFirstName(String fName){
            this.firstName = fName;
            return this;
        }
        public Builder setId(String iD){
            this.id = iD;
            return this;
        }
        public Builder setPasalNumber(int pasal){
            this.pasalNumber = pasal;
            return this;
        }

        public PutRequest build(){return new PutRequest(this);}
    }
}
