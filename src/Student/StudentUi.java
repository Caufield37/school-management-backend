package Student;

import java.util.*;


public class StudentUi {

    Scanner scan = new Scanner(System.in);
    StudentDao studentDao = new StudentDao();

    public void adding() {


        System.out.println("Welcome to student adding application");

        System.out.print("Enter the student's first name: ");
        String first_name = scan.nextLine().trim();

        System.out.print("Enter the student's last name: ");
        String last_name = scan.nextLine().trim();

        System.out.print("Enter the student's gpa: ");
        double gpa = Double.parseDouble(scan.nextLine());

        System.out.print("Enter the student's age: ");
        int age = Integer.parseInt(scan.nextLine());

        System.out.print("Enter the student's grade: ");
        String grade = scan.nextLine().trim();

        System.out.println("Enter the classroom id: ");
        Integer classroom_id = Integer.parseInt(scan.nextLine());

        Student newStudent = new Student(first_name, last_name, gpa, age, grade, classroom_id);

        System.out.println("Passing student into dao layer....");

        studentDao.insertStudent(newStudent);

        System.out.println("Process completed...");
    }

    public void retrieving() {

        System.out.println("=== STUDENT RETRIEVAL SYSTEM ===");
        System.out.print("Enter Student.Student ID to search: ");
        int searchId = Integer.parseInt(scan.nextLine().trim());

        System.out.println("\nUI: Requesting student data from the DAO layer...");

        // 1. Call the DAO layer to get the Student.Student object container
        Student student = studentDao.getStudentById(searchId);

        // 2. Check if a student container was returned
        if (student != null) {
            System.out.println("\n🎉 Student.Student Record Found!");
            System.out.println("---------------------------------");
            System.out.println("Full Name:  " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Age:        " + student.getAge());
            System.out.println("Grade:      " + student.getGrade());
            System.out.println("GPA:        " + student.getGpa());
            System.out.println("---------------------------------");
        } else {
            System.out.println("\n❌ No student found with ID: " + searchId);
        }
    }

    public void updating() {
        System.out.println("Welcome to student updating application....");
        System.out.print("Enter student's id to update: ");
        int id = Integer.parseInt(scan.nextLine());

        Student student = studentDao.getStudentById(id);
        if(student == null) {
            System.out.println("can't find...");
            return;
        }

        System.out.println("What would you like to update? ");
        System.out.println("1. updating first name");
        System.out.println("2. updating last name");
        System.out.println("3. updating gpa");
        System.out.println("4. updating age");
        System.out.println("5. updating grade");

        System.out.print("Enter your choice: ");
        int updateChoice = Integer.parseInt(scan.nextLine());

        switch (updateChoice) {
            case 1 -> {
                System.out.print("Enter new first name: ");
                String newFirst_name = scan.nextLine();
                student.setFirstName(newFirst_name);
            }

            case 2 -> {
                System.out.print("Enter new second name: ");
                String newLast_name = scan.nextLine();
                student.setLastName(newLast_name);
            }

            case 3 -> {
                System.out.print("Enter new gpa: ");
                double new_Gpa = Double.parseDouble(scan.nextLine());
                student.setGpa(new_Gpa);
            }

            case 4 -> {
                System.out.print("Enter new age: ");
                int new_age = Integer.parseInt(scan.nextLine());
                student.setAge(new_age);
            }

            case 5 -> {
                System.out.print("Enter new grade: ");
                String new_grade = scan.nextLine();
                student.setGrade(new_grade);
            }

            default -> {
                System.out.println("invalid number...");
            }
        }
        studentDao.updateStudentById(student, id);
        System.out.println("successfully updated...");

    }

    public void deleting() {
        System.out.println("Welcome to student deleting application");
        System.out.print("Enter a student id that you want to delete: ");
        int id = Integer.parseInt(scan.nextLine());
        studentDao.deleteStudentById(id);
    }

    public void displayingStudentUi() {
        System.out.println("_________________________________________________");
        System.out.println("Welcome to student management application....");
        System.out.println("_________________________________________________");


        boolean isRunning = true;
        while(isRunning) {
            System.out.println("1. Adding new students");
            System.out.println("2. Viewing student");
            System.out.println("3. Updating student");
            System.out.println("4. Deleting student");
            System.out.println("5. Exit");
            System.out.print("Enter a number: ");
            int choice = 0;
            try{
                choice = Integer.parseInt(scan.nextLine());
            } catch(NumberFormatException e) {
                System.out.println(e.getMessage());
            }


            switch (choice) {
                case 1 -> adding();
                case 2 -> retrieving();
                case 3 -> updating();
                case 4 -> deleting();
                case 5 -> isRunning = false;
                default -> System.out.println("Invalid choice");
            }
        }

    }
}


