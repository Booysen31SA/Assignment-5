package com.Booysen31SA.domain.retirement;

public class Retirement implements RetirementIdentity, RetirementNames, Payout {

    private String persal_Num;
    private String iD;
    private String firstName;
    private String lastName;
    private double payout;

    public Retirement(String persal_Num, String iD, String firstName, String lastName, double payout) {
        this.persal_Num = persal_Num;
        this.iD = iD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.payout = payout;
    }

    public Retirement(Builder build){
        this.persal_Num = build.persal_Num;
        this.iD = build.iD;
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.payout = build.payout;
    }
    @Override
    public double getPayout() {
        return payout;
    }

    @Override
    public String getPersal_Num() {
        return persal_Num;
    }

    @Override
    public String getiD() {
        return iD;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public static class Builder{
        private String persal_Num;
        private String iD;
        private String firstName;
        private String lastName;
        private double payout;

        public Builder persal_Num(String persal_Num) {
            this.persal_Num = persal_Num;
            return this;
        }
        public Builder iD(String iD) {
            this.iD = iD;
            return this;
        }
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder payout(double payout) {
            this.payout = payout;
            return this;
        }

        public Retirement build() {
            return new Retirement(this);
        }
    }

    @Override
    public String toString() {
        return  "persal_Num:" + persal_Num +
                "\niD       :" + iD +
                "\nfirstName:" + firstName  +
                "\nlastName :" + lastName +
                "\npayout   :" + payout;
    }
}
