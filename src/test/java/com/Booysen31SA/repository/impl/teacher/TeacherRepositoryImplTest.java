package com.Booysen31SA.repository.impl.teacher;

import com.Booysen31SA.util.genericvalueobjects.ContactDetails;
import com.Booysen31SA.domain.teacher.Teacher;
import com.Booysen31SA.factory.teacherFactory.TeacherFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherRepositoryImplTest {

    TeacherRepositoryImpl teacher;

    @Before
    public void setUp() {
       teacher = TeacherRepositoryImpl.getRepository();
    }


    @Test
    public void create() {
        ContactDetails con = new ContactDetails.Builder().setHomeNumber("074548523").setCellNumber("1520656956").build();
        Teacher teach = TeacherFactory.AddTeacher(216062241, "Matthew", "Booysen",
                                                  "17/02/1997", com.Booysen31SA.util.Misc.generateId(), "32 South Road",
                                                  null, "Male", "White", con);
        teacher.create(teach);
        assertNotNull(teacher.getAll());
        System.out.println(teacher.getAll());
    }

    @Test
    public void update() {
        ContactDetails con = new ContactDetails.Builder().setHomeNumber("074548523").setCellNumber("1520656956").build();
        Teacher teach = TeacherFactory.AddTeacher(216062241, "Matthew", "Booysen",
                "17/02/1997", com.Booysen31SA.util.Misc.generateId(), "32 South Road",
                null, "Male", "White", con);
        teacher.create(teach);
        System.out.println(teacher.getAll());

        ContactDetails updateCon = new ContactDetails.Builder().setHomeNumber("074548523").setCellNumber("1520656956").build();
        Teacher updateTeach = TeacherFactory.AddTeacher(216062241, "Matthew", "Petersen",
                "17/02/1997", com.Booysen31SA.util.Misc.generateId(), "1 Garden Cresent",
                null, "Male", "White", updateCon);

        teacher.update(updateTeach);
        assertEquals(updateTeach, teacher.read(216062241));
        System.out.println("*******************CHANGE************************");
        System.out.println(teacher.getAll());
    }

    @Test
    public void delete() {
        ContactDetails con = new ContactDetails.Builder().setHomeNumber("074548523").setCellNumber("1520656956").build();
        Teacher teach = TeacherFactory.AddTeacher(216062241, "Matthew", "Booysen",
                "17/02/1997", com.Booysen31SA.util.Misc.generateId(), "32 South Road",
                null, "Male", "White", con);
        teacher.create(teach);
        assertNotNull(teacher.read(216062241));

        teacher.delete(216062241);
        assertNull(teacher.read(216062241));
        System.out.println(teacher.getAll());
    }

    @Test
    public void read() {
        ContactDetails con = new ContactDetails.Builder().setHomeNumber("074548523").setCellNumber("1520656956").build();
        Teacher teach = TeacherFactory.AddTeacher(216062241, "Matthew", "Booysen",
                "17/02/1997", com.Booysen31SA.util.Misc.generateId(), "32 South Road",
                null, "Male", "White", con);

        teacher.create(teach);
        assertNotNull(teacher.read(216062241));
        System.out.println(teacher.read(216062241));
    }

}