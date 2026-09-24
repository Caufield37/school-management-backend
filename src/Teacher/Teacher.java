package Teacher;

public class Teacher {

    private String firstName;
    private String lastName;
    private int age;
    private String subject;
    private int teacherId;


    public Teacher(String firstName, String lastName, int age, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subject = subject;
    }

    public void setTeacherID(int teacherID) {this.teacherId = teacherID;}

    public void setFirstName(String first_name) {this.firstName = firstName;}

    public void setLastName(String last_name) {this.lastName = last_name;}

    public void setAge(int age) {this.age = age;}

    public void setSubject(String subject) {this.subject = subject;}

    public String getFirstName() {return this.firstName;}

    public String getLastName() {return this.lastName;}

    public int getAge() {return this.age;}

    public String getSubject() {return  this.subject;}
}
