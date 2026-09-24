package Teacher;

import Student.Student;
import Student.StudentDao;

import java.util.List;
import java.util.Scanner;

public class TeacherUi {

    Scanner scan = new Scanner(System.in);
    TeacherDao teacherDao = new TeacherDao();

    public void adding() {


        System.out.println("Welcome to teacher adding application");

        System.out.print("Enter the teacher's first name: ");
        String first_name = scan.nextLine().trim();

        System.out.print("Enter the teacher's last name: ");
        String last_name = scan.nextLine().trim();

        System.out.print("Enter the teacher's age: ");
        int age = Integer.parseInt(scan.nextLine());

        System.out.print("Enter the student's subject: ");
        String subject = scan.nextLine().trim();

        Teacher newTeacher = new Teacher(first_name, last_name, age, subject);

        System.out.println("Passing student into dao layer....");

        teacherDao.insertTeacher(newTeacher);

        System.out.println("Process completed...");
    }

    public void teacherRetriving() {
        System.out.print("Enter an id to get information about that specific teacher: ");
        int teacherId = Integer.parseInt(scan.nextLine());

        Teacher teacher = teacherDao.getTeacherById(teacherId);

        if(teacher != null) {
            System.out.println("Teacher: " + teacher.getFirst_name() + " " + teacher.getLast_name());
            System.out.println("Age: " + teacher.getAge());
            System.out.println("Subject: " + teacher.getSubject());
        } else{
            System.out.println("that teacher does not exist....");
        }
    }

    public void gettingAllTeacher() {
        List<Teacher> teacherList = teacherDao.getAllTeachers();

        for(Teacher teacher : teacherList) {
            System.out.println(teacher.getFirst_name() + " " + teacher.getLast_name());
            System.out.println("Age: " + teacher.getAge());
            System.out.println("Subject: " + teacher.getSubject());
        }
    }

    public void updating(){
        System.out.print("Enter a teacher's id to update: ");
        int id = Integer.parseInt(scan.nextLine());

        Teacher teacher = teacherDao.getTeacherById(id);

        if(teacher == null) {
            System.out.println("Can't find the teacher..");
            return;
        }

        System.out.println("What would you like to update? ");
        System.out.println("1. Updating first name");
        System.out.println("2. Updating last name");
        System.out.println("3. Updating age");
        System.out.println("4. Updating subject");

        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(scan.nextLine());

        switch (choice) {
            case 1 -> {
                System.out.println("Enter the new first name:");
                teacher.setFirst_name(scan.next());
            }
            case 2 -> {
                System.out.println("Enter the new last name: ");
                teacher.setLast_name(scan.nextLine());
            }
            case 3 -> {
                System.out.println("Enter the new age: ");
                teacher.setAge(Integer.parseInt(scan.nextLine()));
            }
            case 4 -> {
                System.out.println("Enter the new subject: ");
                teacher.setSubject(scan.nextLine());
            }
            default -> {
                System.out.println("invalid number");
                break;
            }
        }
        teacherDao.updateTeacherById(teacher, id);
        System.out.println("updated successfully...");

    }

    public void deleting(){
        System.out.print("Enter the teacher id that you want to delete: ");
        int id = Integer.parseInt(scan.nextLine());

        teacherDao.deleteTeacherById(id);
    }

    public void displayingTeacherUi(){

        System.out.println("Teacher user interface....");


        int choice = 0;

        boolean isRunning = true;
        while(isRunning) {
            System.out.println("1. Adding new teacher....");
            System.out.println("2. Search teacher using Id...");
            System.out.println("3. Updating the information about teacher...");
            System.out.println("4. Deleting teacher by using id...");
            System.out.println("5. View teachers..");
            System.out.println("6. Exit");
            System.out.print("Enter a number (1-5): ");

            try{
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }



            switch (choice) {
                case 1 -> adding();
                case 2 -> teacherRetriving();
                case 3 -> updating();
                case 4 -> deleting();
                case 5 -> gettingAllTeacher();
                case 6 -> isRunning = false;
                default -> {
                    System.out.println("Invalid number");
                }
            }
        }

    }
}
