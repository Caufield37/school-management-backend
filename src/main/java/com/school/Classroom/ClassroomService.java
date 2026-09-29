package com.school.Classroom;

import com.school.Student.Student;
import com.school.Student.StudentAcademicProfile;
import com.school.Student.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final StudentRepository studentRepository;

    public ClassroomService(ClassroomRepository classroomRepository, StudentRepository studentRepository) {
        this.classroomRepository = classroomRepository;
        this.studentRepository = studentRepository;
    }

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public StudentAcademicProfile getStudentAcademicProfile(Long studentId) {
        if(studentId == null || studentId <= 0) {
            throw new IllegalArgumentException("Student id must be greater than zero.");
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + studentId));

        String className = null;
        String teacherName = null;

        if(student.getClassroom() != null) {
            className = student.getClassroom().getClassname();
            if(student.getClassroom().getTeacher() != null) {
                teacherName = student.getClassroom().getTeacher().getName();
            }
        }

        return new StudentAcademicProfile(student.getFirstName(),
                student.getLastName(),
                className,
                teacherName);}


}


