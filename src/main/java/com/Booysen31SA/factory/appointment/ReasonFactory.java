package com.Booysen31SA.factory.appointment;

import com.Booysen31SA.domain.appointment.Reason;

public class ReasonFactory {
    public static Reason buildReason(String persal_Number, String reason){
        return new Reason(persal_Number, reason);
    }
}