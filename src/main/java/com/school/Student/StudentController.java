package com.school.Student;


import org.springframework.web.bind.annotation.*;
import com.school.Student.StudentDao;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentDao studentDao;

    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/{name}")
    public String studentByName(@PathVariable String name) {
        return "Hello" + name;
    }

    @GetMapping
    public List<Student> allStudents() {
        return studentDao.getAllStudents();
    }

    @PostMapping
    public String createStudent(@RequestBody Student student) {
        studentDao.insertStudent(student);
        return "Student: " + student.getFirstName() + " is successfully added";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        studentDao.deleteStudentById(id);
        return "Student: " + id + " is deleted successfully.";
    }


}
