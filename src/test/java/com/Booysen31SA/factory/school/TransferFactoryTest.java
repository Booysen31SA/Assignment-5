package com.Booysen31SA.factory.school;

import com.Booysen31SA.domain.school.Transfer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransferFactoryTest {

    private Transfer transfer;

    @Before
    public void setUp() throws Exception {
        transfer = TransferFactory.buildTransfer("216062241", "scs", "sdcsd", 60000);
    }

    @Test
    public void buildTransfer()
    {
        System.out.println(transfer);
        assertNotNull(transfer);
    }
}