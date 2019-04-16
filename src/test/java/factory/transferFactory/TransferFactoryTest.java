package factory.transferFactory;

import domain.school.Transfer;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransferFactoryTest {

    @Test
    public void transferSchool() {

        System.out.println("\nteacher amount increment");
        int currentAmountOfTeachersAtSchool = 21;
        String beforeTransfer = "South Peninsula";

        Transfer transfer = new TransferFactory().TransferSchool(216062241,
                                                                beforeTransfer,
                                                               "Plumstead High Transfer",
                                                                currentAmountOfTeachersAtSchool,
                                                                "Pending");

        System.out.println(transfer);
        assertNotEquals(currentAmountOfTeachersAtSchool, transfer.getTeacherAmount());
        assertNotEquals(transfer.getSchoolName(), transfer.getPreviousSchool());
    }

    @Test
    public void notTheSame(){
        System.out.println("\nprevious school and new school not the same");
        int currentAmountOfTeachersAtSchool = 21;
        String beforeTransfer = "South Peninsula";

        Transfer transfer = new TransferFactory().TransferSchool(216062241,
                beforeTransfer,
                "Plumstead High Transfer",
                currentAmountOfTeachersAtSchool,
                "Pending");

        System.out.println(transfer);
        assertNotEquals(transfer.getSchoolName(), transfer.getPreviousSchool());
    }
}