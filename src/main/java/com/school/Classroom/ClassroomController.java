package com.school.Classroom;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/classrooms")
public class ClassroomController {

    private final ClassroomDao classroomDao;

    public ClassroomController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    @GetMapping("/{name}")
    public String classroomByName(@PathVariable String name){
        return "Welcome " + name;
    }

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomDao.getAllClassroom();
    }
}
