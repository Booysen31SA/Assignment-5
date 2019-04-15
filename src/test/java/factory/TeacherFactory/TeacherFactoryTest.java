package factory.TeacherFactory;

import Util.Misc;
import domain.Teacher.Teacher;
import factory.TeacherFactory.TeacherFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherFactoryTest {

    @Test
    public void getTeacher() {

        String name = "Teacher List";
        Teacher teach = TeacherFactory.AddTeacher(216062241,
                "Matthew",
                "Booysen",
                "17/02/1997",
                Misc.generateId(),
                "32 South Road",
                "",
                "Male",
                "Coloured",
                 "0721873430",
                "");


        System.out.println(teach);
        assertNotNull(teach);
    }
}