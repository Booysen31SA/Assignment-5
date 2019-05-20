package com.Booysen31SA.domain.retirement;

public class Retirement extends Status {

    protected int pasalNumber;
    protected String id;
    protected String firstName;
    protected String lastName;
    protected double payout;


    public void setPasalNumber(int pasalNumber) {
        this.pasalNumber = pasalNumber;
    }

    @Override
    public String toString() {
        return  "pasalNumber:" + pasalNumber +
                "\nid       :" + id +
                "\nfirstName:" + firstName  +
                "\nlastName :" + lastName +
                "\npayout   :" + payout +
                "\nstatus   :" + request;
    }
}
