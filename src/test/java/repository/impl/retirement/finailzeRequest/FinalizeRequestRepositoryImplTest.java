package repository.impl.retirement.finailzeRequest;

import domain.retirement.FinalizeRequest;
import factory.finalizeRequest.FinalizeRequestFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FinalizeRequestRepositoryImplTest {

    FinalizeRequestRepositoryImpl finalize;

    @Before
    public void setUp() throws Exception {
        finalize = FinalizeRequestRepositoryImpl.getFinailzeRequest();
    }

    @Test
    public void getAll() {
    }

    @Test
    public void create() {
        FinalizeRequest finalR = FinalizeRequestFactory.Update(216062245, Util.Misc.generateId(), 50000.0, "Approved");

        finalize.create(finalR);
        assertNotNull(finalize.getAll());
        System.out.println(finalize.getAll());
    }

    @Test
    public void update() {
        FinalizeRequest finalR = FinalizeRequestFactory.Update(216062241, Util.Misc.generateId(), 50000.0, "Declined");

        finalize.create(finalR);
        FinalizeRequest updatefinalR = FinalizeRequestFactory.Update(216062241, Util.Misc.generateId(), 4000.0, "Approved");
        finalize.update(updatefinalR);
        assertEquals(updatefinalR, finalize.read(216062241));
        System.out.println(finalize.getAll());
    }

    @Test
    public void delete() {
        FinalizeRequest finalR = FinalizeRequestFactory.Update(216062241, Util.Misc.generateId(), 50000.0, "Approved");

        finalize.create(finalR);
        System.out.println(finalize.getAll());
        finalize.delete(216062241);
        assertNull(finalize.read(216062241));
        System.out.println(finalize.getAll());
    }

    @Test
    public void read() {
    }
}