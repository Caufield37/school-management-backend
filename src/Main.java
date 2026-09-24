import Student.StudentUi;
import Teacher.TeacherUi;
import Classroom.*;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        main_menu();



    }

    public static void main_menu() {
        Scanner scanner = new Scanner(System.in);

        TeacherUi teacherUi = new TeacherUi();
        StudentUi studentUi = new StudentUi();
        ClassroomUi classroomUi = new ClassroomUi();

        System.out.println("____________________________________________");
        System.out.println("Welcome to Student Management Application");
        System.out.println("____________________________________________");

        System.out.println("1. Student");
        System.out.println("2. Teacher");
        System.out.println("3. Classroom");
        System.out.println("4. Quit");

        System.out.print("Enter a number(1,2,3): ");
        int choice = 0;
        try{
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }


        switch (choice) {
            case 1 -> studentUi.displayingStudentUi();
            case 2 -> teacherUi.displayingTeacherUi();
            case 3 -> classroomUi.displayingClassroomUi();
            case 4 -> {}
            default -> System.out.println("Invalid number");
        }

        scanner.close();
    }
}
