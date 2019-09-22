package com.Booysen31SA.domain.teacher.user.appointed;

public class DateAppointed {
    String persal_Number;
    String date;

    public DateAppointed(String persal_Number, String date){
      this.persal_Number = persal_Number;
      this.date = date;
    }

    public String getPersal_Number() {
        return persal_Number;
    }

    public void setPersal_Number(String persal_Number) {
        this.persal_Number = persal_Number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
