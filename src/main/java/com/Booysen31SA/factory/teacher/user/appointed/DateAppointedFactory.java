package com.Booysen31SA.factory.teacher.user.appointed;

import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;

public class DateAppointedFactory {
    public static DateAppointed buildDateAppointed(String persal_Number, String date){
        return new DateAppointed(persal_Number, date);
    }
}
