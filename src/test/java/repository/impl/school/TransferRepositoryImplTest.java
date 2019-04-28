package repository.impl.school;

import domain.school.Transfer;
import factory.transferFactory.TransferFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransferRepositoryImplTest {

    TransferRepositoryImpl transfer;

    @Before
    public void setUp() throws Exception {
    transfer = TransferRepositoryImpl.getTransfer();
    }

    @Test
    public void create() {
        Transfer trans = TransferFactory.TransferSchool(216062241, "Plumstead", "South Peninusla", 30000, "Approved");
        transfer.create(trans);
        assertNotNull(transfer.getAll());
    }

    @Test
    public void update() {
        Transfer trans = TransferFactory.TransferSchool(216062241, "Plumstead", "South Peninusla", 30000, "Declined");
        transfer.create(trans);

        Transfer updatetrans = TransferFactory.TransferSchool(216062241, "Plumstead", "South Peninusla", 30000, "Approved");
        transfer.update(updatetrans);
        assertEquals(updatetrans, transfer.read(216062241));
    }

    @Test
    public void delete() {
        Transfer trans = TransferFactory.TransferSchool(216062241, "Plumstead", "South Peninusla", 30000, "Declined");
        transfer.create(trans);

        transfer.delete(216066241);
        assertNull(transfer.read(216066241));
    }

    @Test
    public void read() {
        Transfer trans = TransferFactory.TransferSchool(216062241, "Plumstead", "South Peninusla", 30000, "Declined");
        transfer.create(trans);

        assertNotNull(transfer.read(216062241));
    }
}