package factory;

import domain.Teacher.Teachers;

public class TeacherFactory {

    public static Teachers InsertTeacher(int persal_Num, String first_Name, String last_Name, String date_Of_Birth, String iD){

        return  new Teachers.Builder().setPersalNum(persal_Num)
                                      .setFirst_Name(first_Name)
                                      .setLast_Name(last_Name)
                                      .setDate_Of_Birth(date_Of_Birth)
                                      .setID(iD).build();
    }
}
