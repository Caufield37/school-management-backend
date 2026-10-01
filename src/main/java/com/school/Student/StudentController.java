package com.school.Student;


import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/greet/{name}")
    public String studentByName(@PathVariable String name) {
        return "Hello" + name;
    }

    @GetMapping
    public List<Student> allStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public String createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return "Student: " + student.getFirstName() + " is successfully added";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student: " + id + " is deleted successfully.";
    }


}
