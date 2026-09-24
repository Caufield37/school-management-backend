package Student;

public class Student {
    private String first_name;
    private String last_name;
    private double gpa;
    private int age;
    private String grade;
    private Integer classroomId;

    public Student(String first_name, String last_name, double gpa, int age, String grade, Integer classroomId) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gpa = gpa;
        this.age = age;
        this.grade = grade;
        this.classroomId = classroomId;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getFirst_name() {return this.first_name;}

    public String getLast_name() {return this.last_name;}

    public double getGpa() {return this.gpa;}

    public int getAge() {return this.age;}

    public String getGrade() {return  this.grade;}

}
