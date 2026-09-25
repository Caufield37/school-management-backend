package com.school.Classroom;

import com.school.Student.Student;
import com.school.Teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private int classroomId;
    private String classroomName;
    private int teacherId;

    public Classroom(int classroomId, String classroomName, int teacherId) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
        this.teacherId = teacherId;
    }

    public int getClassroomId(){
        return this.classroomId;
    }

    public String getClassroomName() {
        return this.classroomName;
    }

    public int getTeacherId(){
        return this.teacherId;
    }
}
