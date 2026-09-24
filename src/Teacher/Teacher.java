package Teacher;

public class Teacher {

    private String first_name;
    private String last_name;
    private int age;
    private String subject;
    private int teacherID;


    public Teacher(String first_name, String last_name, int age, String subject) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.subject = subject;
    }

    public void setTeacherID(int teacherID) {this.teacherID = teacherID;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public void setAge(int age) {this.age = age;}

    public void setSubject(String subject) {this.subject = subject;}

    public String getFirst_name() {return this.first_name;}

    public String getLast_name() {return this.last_name;}

    public int getAge() {return this.age;}

    public String getSubject() {return  this.subject;}
}
