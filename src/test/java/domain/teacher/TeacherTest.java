package domain.teacher;

import Util.genericvalueobjects.ContactDetails;
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

        assertTrue(teach.getContactDetails().getCellNumber().equals("0214587452"));
    }
}