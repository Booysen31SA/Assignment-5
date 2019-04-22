package domain.teacher;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateAppointedTest {

    private DateAppointed date;

    @Before
    public void setUp() throws Exception {
       date = new DateAppointed("17/02/1997");

    }

    @Test
    public void getDate() {
        assertTrue(date.getDate().equals("17/02/1997"));
    }
}