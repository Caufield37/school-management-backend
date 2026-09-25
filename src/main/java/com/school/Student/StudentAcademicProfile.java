package com.school.Student;

public class StudentAcademicProfile {
    private String firstName;
    private String lastName;
    private String classroomName;
    private String teacherName;

    public StudentAcademicProfile(String firstName, String lastName, String classroomName, String teacherName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.classroomName = classroomName;
        this.teacherName = teacherName;
    }

    public String getFirstName() {return this.firstName;}

    public String getLastName() {return this.lastName;}

    public String getClassroomName() {return this.classroomName;}

    public String getTeacherName() {return this.teacherName;}
}
