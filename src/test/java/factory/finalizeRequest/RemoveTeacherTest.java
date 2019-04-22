package factory.finalizeRequest;

import domain.retirement.FinalizeRequest;
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