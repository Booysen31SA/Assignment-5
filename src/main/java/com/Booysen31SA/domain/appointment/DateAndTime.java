package com.Booysen31SA.domain.appointment;

public class DateAndTime {

    private String persal_Number;
    private String date;
    private String time;

    public DateAndTime(String persal_Number, String date, String time) {
        this.persal_Number = persal_Number;
        this.date = date;
        this.time = time;
    }

    public String getPersal_Number() {
        return persal_Number;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
