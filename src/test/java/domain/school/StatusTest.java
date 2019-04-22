package domain.school;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatusTest {

    private Status status;

    @Before
    public void setUp() {

        status = new Status("Approved");
    }

    @Test
    public void getStatusRequest() {
        assertTrue(status.getStatusRequest().equalsIgnoreCase("approved"));
    }
}