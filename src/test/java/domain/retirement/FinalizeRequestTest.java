package domain.retirement;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FinalizeRequestTest {

    private FinalizeRequest finalR;

    @Before
    public void setUp() throws Exception {
        finalR = new FinalizeRequest.Builder().setPasalNumber(216062241).setId("970217").setPayout(78005).setStatus("Declined").build();
    }

    @Test
    public void getPersal_Num() {
        assertTrue(finalR.getPersal_Num() == 216062241);
    }

    @Test
    public void getiD() {
        assertTrue(finalR.getiD().equalsIgnoreCase("970217"));
    }

    @Test
    public void getPayOut() {
        assertTrue(finalR.getPayout() == 78005);
    }

  
}