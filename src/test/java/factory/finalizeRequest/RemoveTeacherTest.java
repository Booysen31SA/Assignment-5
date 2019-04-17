package factory.finalizeRequest;

import Util.Misc;
import domain.retirement.FinalizeRequest;
import domain.teacher.Teacher;
import factory.teacherFactory.UpdateFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveTeacherTest {

    @Test
    public void remove() {
        String name = "teacher List";

        FinalizeRequest finalreg = RemoveTeacherFactory.remove(216062241);

        System.out.println(finalreg);
        assertNotNull(finalreg);
    }
}