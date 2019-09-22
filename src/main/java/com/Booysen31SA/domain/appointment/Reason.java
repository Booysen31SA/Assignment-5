package com.Booysen31SA.domain.appointment;

public class Reason {

    private String persal_Number;
    private String reason;

    public Reason(String persal_Number, String reason) {
        this.persal_Number = persal_Number;
        this.reason = reason;
    }

    public String getPersal_Number() {
        return persal_Number;
    }

    public String getReason() {
        return reason;
    }
}
