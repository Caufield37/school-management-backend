package com.school.Student;


import com.school.Classroom.Classroom;
import com.school.Classroom.ClassroomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;

    public StudentService(StudentRepository studentRepository, ClassroomRepository classroomRepository) {

        this.studentRepository = studentRepository;
        this.classroomRepository = classroomRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId){
        return studentRepository.findById(studentId).orElse(null);
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


        studentRepository.save(student);
        return true;
    }

    @Transactional
    public Student transferStudent(Long studentId, Long targetClassroomId) {

        Student student = studentRepository.findById(studentId).
                orElseThrow(() -> new IllegalArgumentException("Can not be found student with id: " + studentId) );

        Classroom targetClassroom = classroomRepository.findById(studentId).
                orElseThrow(() -> new IllegalArgumentException("Can not be found student with id: " + studentId) );

        student.setClassroom(targetClassroom);

        return studentRepository.save(student);

    }

    public boolean deleteStudent(Long studentId) {
        if(studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;

    }

    @Transactional
    public List<Student> getAllStudentsByClassId(Long classId) {
        return studentRepository.findByClassroomId(classId);
    }
}
