package com.school.Teacher;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getSpecificTeacher(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }


    @PostMapping
    public String createTeacher(@RequestBody Teacher teacher) {
        teacherService.createTeacher(teacher);
        return "Teacher: " + teacher.getFirstName() + " is successfully added";
    }



    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return "Teacher: " + id + " is deleted successfully";
    }


}
