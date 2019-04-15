package factory.TeacherFactory;

import domain.Teacher.Teacher;

public class TeacherFactory {

    public static Teacher AddTeacher(int persal_Num, String first_Name, String last_Name, String date_Of_Birth, String iD, String pAddress, String posAdd,
                                     String gender, String race, String cell, String home){

        return  new Teacher.Builder().setPersalNum(persal_Num)
                                      .setFirst_Name(first_Name)
                                      .setLast_Name(last_Name)
                                      .setDate_Of_Birth(date_Of_Birth)
                                      .setID(iD)
                                      .setPhysicalAddress(pAddress)
                                      .setPostalAddress(posAdd)
                                      .setGender(gender)
                                      .setRace(race)
                                      .setCellNumber(cell)
                                      .setHomeNumber(home).build();
    }
}
