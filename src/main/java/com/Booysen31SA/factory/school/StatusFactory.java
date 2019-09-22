package com.Booysen31SA.factory.school;

import com.Booysen31SA.domain.school.Status;

public class StatusFactory {
    public static Status buildStatus(String persal_Number, String status){
        return new Status(persal_Number, status);
    }
}
