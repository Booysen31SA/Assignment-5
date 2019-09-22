package com.Booysen31SA.domain.retirement;

public class Retirement implements RetirementIdentity, RetirementNames, Payout {

    private String persal_Number;
    private long id;
    private String firstName;
    private String lastName;
    private double payout;

    public Retirement(Builder build){
        this.persal_Number = build.persal_Number;
        this.id = build.id;
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.payout = build.payout;
    }
    @Override
    public double getPayout() {
        return 0;
    }

    @Override
    public String getPersal_Num() {
        return null;
    }

    @Override
    public String getiD() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    public static class Builder{
        private String persal_Number;
        private long id;
        private String firstName;
        private String lastName;
        private double payout;

        public Builder persal_Number(String persal_Number) {
            this.persal_Number = persal_Number;
            return this;
        }
        public Builder id(long id) {
            this.id = id;
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
        return  "pasalNumber:" + persal_Number +
                "\nid       :" + id +
                "\nfirstName:" + firstName  +
                "\nlastName :" + lastName +
                "\npayout   :" + payout;
    }
}
