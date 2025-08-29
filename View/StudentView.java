package View;

import java.util.Scanner;

import Controller.EnrollmentController;

import Controller.dto.StudentDto;

public class StudentView {
    private final EnrollmentController enrollmentController;

    public StudentView(EnrollmentController enrollmentController) {
        this.enrollmentController = enrollmentController;
    }

    public void studentMenu(Scanner scanner, StudentDto studentDto) {
        while (true) {

        System.out.println("Choose an option:");
        System.out.println("1. Enroll in a course");
        System.out.println("2. View enrolled courses");
        System.out.println("3. View available courses");
        System.out.println("4. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter the course name:");
                String courseName = scanner.nextLine();
                enrollmentController.enrollInCourse(courseName, studentDto);
                break;
            case 2:
                // View enrolled courses
                break;
            case 3:
                // View available courses
                break;
            case 4:
                System.out.println("Goodbye! See you next time!");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    }
    
}
