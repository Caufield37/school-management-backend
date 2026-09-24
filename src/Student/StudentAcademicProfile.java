package Student;

public class StudentAcademicProfile {
    private String first_name;
    private String last_name;
    private String classroom_name;
    private String teacher_name;

    public StudentAcademicProfile(String first_name, String last_name, String classroom_name, String teacher_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.classroom_name = classroom_name;
        this.teacher_name = teacher_name;
    }

    public String getFirst_name() {return this.first_name;}

    public String getLast_name() {return this.last_name;}

    public String getClassroom_name() {return this.classroom_name;}

    public String getTeacher_name() {return this.classroom_name;}
}
