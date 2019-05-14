package com.Booysen31SA.factory.teacherFactory;

import com.Booysen31SA.util.genericvalueobjects.ContactDetails;
import com.Booysen31SA.domain.teacher.Teacher;

public class UpdateFactory {

    public static Teacher UpdateTeacher(int persal_Num, String first_Name, String last_Name, String date_Of_Birth, String iD, String pAddress, String posAdd,
                                        String gender, String race, ContactDetails con){

        return new Teacher.Builder().setPersalNum(persal_Num)
                .setFirst_Name(first_Name)
                .setLast_Name(last_Name)
                .setDate_Of_Birth(date_Of_Birth)
                .setID(iD)
                .setPhysicalAddress(pAddress)
                .setPostalAddress(posAdd)
                .setGender(gender)
                .setRace(race)
                .contactDetails(con)
                .build();
    }
}
