package com.Booysen31SA.factory.retirement;

import com.Booysen31SA.domain.retirement.Status;

public class StatusFactory {
    public static Status buildStatus(String persal_Number, String request){
        return new Status(persal_Number, request);
    }
}
