package com.Booysen31SA.factory.teacherFactory;

import com.Booysen31SA.domain.teacher.Teacher;
import com.Booysen31SA.util.Misc;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherFactoryTest {

    @Test
    public void getTeacher() {


        String name = "teacher List";
        Teacher teach = TeacherFactory.AddTeacher(216062241,
                "Matthew",
                "Booysen",
                "17/02/1997",
                Misc.generateId(),
                "32 South Road",
                "",
                "Male",
                "Coloured",
                 null);


        System.out.println(teach);
        assertNotNull(teach);
    }
}