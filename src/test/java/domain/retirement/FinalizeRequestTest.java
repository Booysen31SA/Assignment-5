package domain.retirement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FinalizeRequestTest {

    private FinalizeRequest finalR;

    @Before
    public void setUp() {
        finalR = new FinalizeRequest.Builder().setPasalNumber(216062241).setId("970217").setPayout(78005).setStatus("Declined").build();
    }

    @Test
    public void getPersal_Num() {
        assertEquals(216062241, finalR.getPersal_Num());
    }

    @Test
    public void getiD() {
        assertTrue(finalR.getiD().equalsIgnoreCase("970217"));
    }

    @Test
    public void getPayOut() {
        assertEquals(78005, finalR.getPayout(), 0.0);
    }

  
}