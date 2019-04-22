package factory.teacherFactory;

import Util.Misc;
import domain.teacher.Teacher;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateFactoryTest {

    @Test
    public void updateTeacher() {

        String name = "teacher List";
        Teacher teach = UpdateFactory.UpdateTeacher(216062241,
                "Matthew",
                "Booysen",
                "17/02/1997",
                Misc.generateId(),
                "32 South Road",
                "",
                "Male",
                "Coloured",
                null);


        System.out.println(teach);
        assertNotNull(teach);
    }
}