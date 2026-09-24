package Classroom;

import Student.Student;
import Teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String className;
    private int numberOfStudents;
    private Teacher teacher;
    private List<Student> students;

    public Classroom(String className, int numberOfStudents, Teacher teacher) {
        this.className = className;
        this.numberOfStudents = numberOfStudents;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public Teacher getTeacher() {return this.teacher;}

    public List<Student> getStudent() {return this.students;}

    public String getClass_name() {return this.className;}

    public int getNumber_of_students(){return this.numberOfStudents;}
}
