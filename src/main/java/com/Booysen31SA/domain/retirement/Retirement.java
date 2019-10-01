package com.Booysen31SA.domain.retirement;

public class Retirement implements RetirementIdentity, RetirementNames, Payout {

    private String persal_Number;
    private String id;
    private String firstName;
    private String lastName;
    private double payout;

    public Retirement(String persal_Number, String id, String firstName, String lastName, double payout) {
        this.persal_Number = persal_Number;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.payout = payout;
    }

    public Retirement(Builder build){
        this.persal_Number = build.persal_Number;
        this.id = build.id;
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
        return persal_Number;
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

    public static class Builder{
        private String persal_Number;
        private String id;
        private String firstName;
        private String lastName;
        private double payout;

        public Builder persal_Number(String persal_Number) {
            this.persal_Number = persal_Number;
            return this;
        }
        public Builder id(String id) {
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
