package factory.teacherFactory;

import Util.Misc;
import domain.teacher.Teacher;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherFactoryTest {

    @Test
    public void getTeacher() {

        String name = "teacher List";
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