package com.Booysen31SA.controller.teacher;

import com.Booysen31SA.domain.teacher.Teacher;
import com.Booysen31SA.factory.teacherFactory.TeacherFactory;
import com.Booysen31SA.services.impl.teacher.TeacherService;
import com.Booysen31SA.util.Misc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

//    @GetMapping("/create/{persal_Num}/{first_Name}")
//    public @ResponseBody
//    Teacher create(@PathVariable Integer persal_Num,@PathVariable String first_Name){//http://localhost:8080/teacher/create/216062241/Booysen
//        Teacher teacher = TeacherFactory.AddTeacher(persal_Num, first_Name, "Booysen", "17/02/1997", Misc.generateId(), null, null, "Male", "White", null);
//        return service.create(teacher);
//    }

    @PostMapping("/create")
    @ResponseBody
    public Teacher create(Teacher teacher){
        return service.create(teacher);
    }

    @PostMapping("/update")
    @ResponseBody
    public Teacher update(Teacher teacher){
        return service.update(teacher);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Teacher read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Teacher> getAll() {
        return service.getAll();
    }
}
