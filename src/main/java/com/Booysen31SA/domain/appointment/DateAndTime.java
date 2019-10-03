package com.Booysen31SA.domain.appointment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DateAndTime {

    @Id
    private String persal_Number;
    private String date;
    private String time;

    public DateAndTime() {
    }

    @Override
    public String toString() {
        return "DateAndTime{" +
                "persal_Number='" + persal_Number + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

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
