package Classroom;

import Student.StudentAcademicProfile;

import java.util.Scanner;

public class ClassroomUi {

    Scanner scanner = new Scanner(System.in);
    ClassroomDao classroomDao = new ClassroomDao();

    public void gettingStudentsDetails() {

        System.out.println("Enter a student's id to view details: ");
        int studentId = Integer.parseInt(scanner.nextLine().trim());

        classroomDao.getStudentDetails(studentId);

        StudentAcademicProfile profile = classroomDao.getStudentDetails(studentId);

        // 2. Guard against null if student doesn't exist
        if (profile == null) {
            System.out.println("❌ No student record found with ID: " + studentId);
            return;
        }

        // 3. Print the joined data
        System.out.println("\n--- Student Academic Profile ---");
        System.out.println("Student Name:    " + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Classroom:       " + (profile.getClassroomName() != null ? profile.getClassroomName() : "Not assigned"));
        System.out.println("Teacher in Charge: " + (profile.getTeacherName() != null ? profile.getTeacherName() : "No teacher assigned"));
        System.out.println("--------------------------------\n");
    }

    public void transferringStudent() {

        System.out.println("Enter a student's id that you want to transfer: ");
        int studentId = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter new classroom id: ");
        int classroomId = Integer.parseInt(scanner.nextLine().trim());

        classroomDao.transferStudent(studentId,classroomId);
    }

    public void transferringTeacher() {

        System.out.println("Enter a teacher's id that you want to transfer: ");
        int teacherId = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter new classroom id: ");
        int classroomId = Integer.parseInt(scanner.nextLine().trim());

        classroomDao.transferTeacher(teacherId, classroomId);
    }

    public void displayingClassroomUi() {

        System.out.println("______________________________________");
        System.out.println("Welcome to classroom section");
        System.out.println("______________________________________");
        System.out.println("1. Student Details");
        System.out.println("2. Transfer student");
        System.out.println("3. Transfer teacher");
        System.out.println("4. Quit");
        System.out.print("Enter a number(1, 2, 3): ");

        int choice = Integer.parseInt(scanner.nextLine().trim());

        switch (choice) {
            case 1 -> gettingStudentsDetails();
            case 2 -> transferringStudent();
            case 3 -> transferringTeacher();
            case 4 -> {}
            default -> System.out.println("invalid number");
        }
    }


}
