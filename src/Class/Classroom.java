package Class;

import Student.Student;
import Teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String class_name;
    private int number_of_students;
    private Teacher teacher;
    private List<Student> students;

    public Classroom(String class_name, int number_of_students, Teacher teacher) {
        this.class_name = class_name;
        this.number_of_students = number_of_students;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public Teacher getTeacher() {return this.teacher;}

    public List<Student> getStudent() {return this.students;}

    public String getClass_name() {return this.class_name;}

    public int getNumber_of_students(){return this.number_of_students;}
}
