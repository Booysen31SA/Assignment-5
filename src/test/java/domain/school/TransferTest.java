package domain.school;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransferTest {

    private Transfer transfer;

    @Before
    public void setUp() throws Exception {
        transfer = new Transfer.Builder().setPasalNumber(216062241).setPreviousSchool("South Peninsula").setSchoolName("plumstead")
                .setStatus("Approved").setTeacherAmount(4500).build();
    }

    @Test
    public void getSchoolName() {
        assertTrue(transfer.getSchoolName().equalsIgnoreCase("plumstead"));
    }

    @Test
    public void getTeacherAmount() {
        assertTrue(transfer.getTeacherAmount() == 4500);
    }

    @Test
    public void getPreviousSchool() {
        assertTrue(transfer.getPreviousSchool().equalsIgnoreCase("South peninsula"));
    }

    @Test
    public void getPersalNumber() {
        assertTrue(transfer.getPersalNumber()==216062241);
    }

}