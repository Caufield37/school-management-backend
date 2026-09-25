package com.school.Student;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int studentId){
        return studentDao.getStudentById(studentId);
    }

    public boolean createStudent(Student student) {

        if(student.getFirstName() == null || student.getFirstName().trim().isEmpty()) {
            throw new IllegalArgumentException("first name can't be empty..");
        }

        if(student.getLastName() == null || student.getLastName().trim().isEmpty()) {
            throw new IllegalArgumentException("last name can't be empty..");
        }

        if(student.getGpa() < 0 || student.getGpa() > 4) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }

        if(student.getAge() < 0 || student.getAge() > 120) {
            throw new IllegalArgumentException("Age must be greater than zero and it's still impossible to live for more than 120 years");
        }

        if(student.getGrade() == null || student.getGrade().trim().isEmpty()) {
            throw new IllegalArgumentException("Grade can't be empty");
        }

        if(student.getClassroomId() > 0) {
            throw new IllegalArgumentException("classroom id can't be less than zero");
        }

        return studentDao.insertStudent(student);
    }
}
