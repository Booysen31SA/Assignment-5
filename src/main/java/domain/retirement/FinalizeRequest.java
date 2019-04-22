package domain.retirement;

public class FinalizeRequest extends Retirement implements RetirementIdentity,Payout{


    Status status;

    public FinalizeRequest(Builder build) {
        this.pasalNumber = build.pasalNumber;
        this.id = build.id;
        this.payout = build.payout;
        this.request = build.status;
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
    public double getPayout() {
        return payout;
    }

    public static class Builder{

        private int pasalNumber;
        private double payout;
        private String status;
        private String id;

        public Builder setStatus(String status){
            this.status = status;
            return this;
        }
        public Builder setPayout(double payout){
            this.payout = payout;
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

        public FinalizeRequest build(){return new FinalizeRequest(this);}
    }


}
