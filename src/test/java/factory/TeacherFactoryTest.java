package factory;

import Util.Misc;
import domain.Teacher.Teachers;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherFactoryTest {

    @Test
    public void getTeacher() {

        String name = "Teacher List";
        Teachers teach = TeacherFactory.InsertTeacher(216062241,
                                                   "Matthew",
                                                   "Booysen",
                                                    "17/02/1997",
                                                                Misc.generateId());
        System.out.println(teach);
        assertNotNull(teach);
    }
}