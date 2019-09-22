package com.Booysen31SA.factory.appointment;

import com.Booysen31SA.domain.appointment.DateAndTime;

public class DateAndTimeFactory {
    public static DateAndTime buildDateAndTime(String persal_Number, String date, String Time){
        return new DateAndTime(persal_Number, date,Time);
    }
}