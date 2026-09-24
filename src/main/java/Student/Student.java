package Student;

public class Student {
    private String firstName;
    private String lastName;
    private double gpa;
    private int age;
    private String grade;
    private Integer classroomId;

    public Student(String firstName, String lastName, double gpa, int age, String grade, Integer classroomId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.age = age;
        this.grade = grade;
        this.classroomId = classroomId;
    }

    public void setFirstName(String first_name) {
        this.firstName = firstName;
    }

    public void setLastName(String last_name) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFirstName() {return this.firstName;}

    public String getLastName() {return this.lastName;}

    public double getGpa() {return this.gpa;}

    public int getAge() {return this.age;}

    public String getGrade() {return  this.grade;}

    public Integer getClassroomId(){return this.classroomId;}

}
