package com.school.Teacher;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId).orElse(null);
    }

    public boolean createTeacher(Teacher teacher) {

        if(teacher.getFirstName() == null || teacher.getFirstName().trim().isEmpty()) {
            throw new IllegalArgumentException("First name can't be empty");
        }

        if(teacher.getLastName() == null || teacher.getLastName().trim().isEmpty()) {
            throw new IllegalArgumentException("Last name can't be empty");
        }




        if(teacher.getAge() < 18 || teacher.getAge() > 65 ) {
            throw new IllegalArgumentException("age must be between 18 to 65");
        }

        if(teacher.getSubject() == null || teacher.getSubject().trim().isEmpty()) {
            throw new IllegalArgumentException("subject can't be empty");
        }

        teacherRepository.save(teacher);
        return true;
    }

    public boolean deleteTeacher(Long teacherId) {
        if(teacherRepository.existsById(teacherId)) {
            teacherRepository.deleteById(teacherId);
            return true;
        }
        return false;
    }
}
