package com.Booysen31SA.domain.appointment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reason {
    @Id
    private String persal_Number;
    private String reason;

    public Reason() {
    }

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
