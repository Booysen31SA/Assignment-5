package com.Booysen31SA.domain.teacher;

import com.Booysen31SA.util.genericvalueobjects.ContactDetails;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherTest {

    private Teacher teach;


    @Test
    public void contactTest(){
        ContactDetails con = new ContactDetails.Builder()
                                 .setCellNumber("0214587452").setHomeNumber("012584512").build();

        teach = new Teacher.Builder()
                .setFirst_Name("Matthew")
                .contactDetails(con).build();

        assertEquals("0214587452", teach.getContactDetails().getCellNumber());
    }
}