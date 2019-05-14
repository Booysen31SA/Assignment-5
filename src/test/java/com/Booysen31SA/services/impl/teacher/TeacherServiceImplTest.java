package com.Booysen31SA.services.impl.teacher;

import com.Booysen31SA.domain.teacher.Teacher;
import com.Booysen31SA.factory.teacherFactory.TeacherFactory;
import com.Booysen31SA.repository.impl.teacher.TeacherRepositoryImpl;
import com.Booysen31SA.util.genericvalueobjects.ContactDetails;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TeacherServiceImplTest {

    private TeacherRepositoryImpl repository;
    private Teacher getClass;

    private Teacher getSaved(){return this.repository.getAll().iterator().next();}

    @Before
    public void setUp() throws Exception {
        this.repository = TeacherRepositoryImpl.getRepository();
        ContactDetails con = new ContactDetails.Builder().setHomeNumber(null).setCellNumber(null).build();
        this.getClass = TeacherFactory.AddTeacher(216062241, "Matthew", "Booysen",
                "17/02/1997", com.Booysen31SA.util.Misc.generateId(), "32 South Road",
                null, "Male", "White", con);

    }

    @Test
    public void getAll() {
    }

    @Test
    public void create() {
        Teacher created = this.repository.create(this.getClass);
        System.out.println("Created : "+created);
        assertNotNull(created);
        assertSame(created, this.getClass);
    }

    @Test
    public void update() {
        Teacher app = this.repository.create(this.getClass);

        repository.create(app);
        ContactDetails con = new ContactDetails.Builder().setHomeNumber("074548523").setCellNumber("1520656956").build();
        Teacher updateapp = TeacherFactory.AddTeacher(216062241, "Matthew", "Booysen",
                "17/02/1997", com.Booysen31SA.util.Misc.generateId(), "32 South Road",
                null, "Male", "White", con);


        repository.update(updateapp);
        assertEquals(updateapp, repository.read(216062241));
        System.out.println(repository.getAll());
    }

    @Test
    public void delete() {
        Teacher app = this.repository.create(this.getClass);

        repository.create(app);

        //appointment.delete(216062241);
        //assertNull(appointment.read(216062241));
        System.out.println(repository.getAll());
    }

    @Test
    public void read() {
        Teacher app =this.repository.create(this.getClass);

        repository.create(app);
        assertNotNull(repository.read(216062241));
        System.out.println(repository.getAll());
    }
}